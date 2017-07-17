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
package org.kuali.coeus.sys.impl.session;


import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SessionHoldingListener implements HttpSessionListener {

    private static final Map<String, HttpSession> SESSION_HOLDER = new ConcurrentHashMap<>();

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        final HttpSession session = se.getSession();
        SESSION_HOLDER.put(session.getId(), session);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        final HttpSession session = se.getSession();
        SESSION_HOLDER.remove(session.getId(), session);
    }

    public static Collection<HttpSession> getSessions() {
        return SESSION_HOLDER.values();
    }
}
