/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.version;

/**
 * This exception will be thrown when an attempted versioning fails
 */
public class VersionException extends RuntimeException {
    private static final long serialVersionUID = 4329253003064449628L;

    public VersionException() {
        super();
    }

    public VersionException(String message, Throwable cause) {
        super(message, cause);
    }

    public VersionException(String message) {
        super(message);
    }

    public VersionException(Throwable cause) {
        super(cause);
    }
    
}
