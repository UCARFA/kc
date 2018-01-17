package org.kuali.coeus.propdev.impl.s2s;
/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

public class UserAttachedFormsXMLReorder extends KcPersistableBusinessObjectBase{
    private Long id;
    private String nodeToMove;
    private String targetNode;
    private boolean moveAfter;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNodeToMove() {
        return nodeToMove;
    }

    public void setNodeToMove(String nodeToMove) {
        this.nodeToMove = nodeToMove;
    }

    public String getTargetNode() {
        return targetNode;
    }

    public void setTargetNode(String targetNode) {
        this.targetNode = targetNode;
    }

    public boolean isMoveAfter() {
        return moveAfter;
    }

    public void setMoveAfter(boolean moveAfter) {
        this.moveAfter = moveAfter;
    }
}
