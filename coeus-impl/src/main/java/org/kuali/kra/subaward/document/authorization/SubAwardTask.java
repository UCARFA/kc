/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.kra.subaward.document.authorization;

import org.kuali.coeus.common.framework.auth.task.Task;
import org.kuali.kra.infrastructure.TaskGroupName;
import org.kuali.kra.subaward.document.SubAwardDocument;


public class SubAwardTask extends Task {

    private SubAwardDocument subAwardDocument;

    /**
     * Constructs a SubAwardTask.java.
     * @param taskName the taskName
     * @param subAwardDocument the SubAwardDocument
     */
    public SubAwardTask(String taskName, SubAwardDocument subAwardDocument) {
        super(TaskGroupName.SUBAWARD, taskName);
        this.setSubAwardDocument(subAwardDocument);
    }

	/**.
	 * This is the Getter Method for subAwardDocument
	 * @return Returns the subAwardDocument.
	 */
	public SubAwardDocument getSubAwardDocument() {
		return subAwardDocument;
	}

	/**.
	 * This is the Setter Method for subAwardDocument
	 * @param subAwardDocument The subAwardDocument to set.
	 */
	public void setSubAwardDocument(SubAwardDocument subAwardDocument) {
		this.subAwardDocument = subAwardDocument;
	}

}
