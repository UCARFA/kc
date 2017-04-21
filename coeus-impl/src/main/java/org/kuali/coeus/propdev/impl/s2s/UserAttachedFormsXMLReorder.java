package org.kuali.coeus.propdev.impl.s2s;
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
