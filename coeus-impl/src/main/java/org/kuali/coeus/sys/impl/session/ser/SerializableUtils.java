/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 *
 * Copyright 2005-2016 Kuali, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.kuali.coeus.sys.impl.session.ser;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

final class SerializableUtils {

    private SerializableUtils() {
        throw new UnsupportedOperationException("do not call");
    }

    static SerInfo getSerializationInfo(Object obj) {
        if (obj == null) {
            return SerInfo.pass(0);
        }

        try (ByteArrayOutputStream bos = new ByteArrayOutputStream(); DebuggingObjectOutputStream oos = new DebuggingObjectOutputStream(bos)) {
            try {
                oos.writeObject(obj);
            } catch (IOException e) {
                return SerInfo.fail(oos.getStack().stream().map(o -> o.getClass().getName()).collect(Collectors.joining("->")));
            }
            bos.flush();
            return SerInfo.pass(bos.size());
        } catch (IOException e) {
            return SerInfo.fail(obj.getClass().getName());
        }
    }

    static class SerInfo {
        private final boolean serializable;
        private final int size;
        private final String failurePath;

        private SerInfo(boolean serializable, int size, String failurePath) {
            this.serializable = serializable;
            this.size = size;
            this.failurePath = failurePath;
        }

        static SerInfo pass(int size) {
            return new SerInfo(true, size, "");
        }

        static SerInfo fail(String failurePath) {
            return new SerInfo(false, -1, failurePath);
        }

        public boolean isSerializable() {
            return serializable;
        }

        public int getSize() {
            return size;
        }

        public String getFailurePath() {
            return failurePath;
        }
    }

    /*
    Code derived from: http://blog.crazybob.org/2007/02/debugging-serialization.html
     */
    public static class DebuggingObjectOutputStream extends ObjectOutputStream {

        private static final Field DEPTH_FIELD;
        static {
            try {
                DEPTH_FIELD = ObjectOutputStream.class
                        .getDeclaredField("depth");
                DEPTH_FIELD.setAccessible(true);
            } catch (NoSuchFieldException e) {
                throw new AssertionError(e);
            }
        }

        private final List<Object> stack = new ArrayList<>();

        /**
         * Indicates whether or not OOS has tried to
         * write an IOException (presumably as the
         * result of a serialization error) to the
         * stream.
         */
        boolean broken = false;

        public DebuggingObjectOutputStream(OutputStream out) throws IOException {
            super(out);
            enableReplaceObject(true);
        }

        /**
         * Abuse {@code replaceObject()} as a hook to
         * maintain our stack.
         */
        @Override
        protected Object replaceObject(Object o) {
            // ObjectOutputStream writes serialization
            // exceptions to the stream. Ignore
            // everything after that so we don't lose
            // the path to a non-serializable object. So
            // long as the user doesn't write an
            // IOException as the root object, we're OK.
            int currentDepth = currentDepth();
            if (o instanceof IOException
                    && currentDepth == 0) {
                broken = true;
            }
            if (!broken) {
                truncate(currentDepth);
                stack.add(o);
            }
            return o;
        }

        private void truncate(int depth) {
            while (stack.size() > depth) {
                pop();
            }
        }

        private Object pop() {
            return stack.remove(stack.size() - 1);
        }

        /**
         * Returns a 0-based depth within the object
         * graph of the current object being
         * serialized.
         */
        private int currentDepth() {
            try {
                Integer oneBased
                        = ((Integer) DEPTH_FIELD.get(this));
                return oneBased - 1;
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }

        /**
         * Returns the path to the last object
         * serialized. If an exception occurred, this
         * should be the path to the non-serializable
         * object.
         */
        public List<Object> getStack() {
            return stack;
        }
    }
}
