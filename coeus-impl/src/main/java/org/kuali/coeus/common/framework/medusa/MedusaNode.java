/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.medusa;

import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.iacuc.IacucProtocol;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;
import org.kuali.kra.irb.Protocol;
import org.kuali.kra.negotiations.bo.Negotiation;
import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.subaward.bo.SubAward;
import org.kuali.rice.core.api.util.tree.Node;

import java.io.Serializable;
import java.util.List;


public class MedusaNode extends Node<Object, String> implements Serializable {
    private static final long serialVersionUID = 6899695450845010658L;
    
    private Object extraInfo;
    private String documentDescription;

    public Object getBo() {
        return getData();
    }
    public void setBo(Object bo) {
    	setData(bo);
    }
    public String getType() {
        return getNodeType();
    }
    public void setType(String type) {
    	setNodeType(type);
    }
    public List<? super MedusaNode> getChildNodes() {
    	return getChildren();
    }
    public void setChildNodes(List<? extends Node<Object, String>> childNodes) {
    	setChildren((List<Node<Object, String>>) childNodes);
    }
    public Object getExtraInfo() {
        return extraInfo;
    }
    public void setExtraInfo(Object extraInfo) {
        this.extraInfo = extraInfo;
    }
    public String getDocumentDescription() { return documentDescription; }
    public void setDocumentDescription(String documentDescription) { this.documentDescription = documentDescription; }
    public void addChildNode(MedusaNode node) {
    	getChildren().add(node);
    }
    @Override
    public String getNodeLabel() {
    	if (getData() instanceof DevelopmentProposal) {
    		return "Development Proposal " + ((DevelopmentProposal) getData()).getProposalNumber();
    	}
        else if (getData() instanceof InstitutionalProposal) {
    		return "Institutional Proposal " + ((InstitutionalProposal) getData()).getProposalNumber();
    	}
        else if (getData() instanceof Protocol) {
            return "IRB Protocol " + ((ProtocolBase) getData()).getProtocolNumber();
        }
        else if (getData() instanceof IacucProtocol) {
            return "IACUC Protocol " + ((ProtocolBase) getData()).getProtocolNumber();
        }
        else if (getData() instanceof Award) {
            return "Award " + ((Award) getData()).getAwardNumber();
        }
        else if (getData() instanceof SubAward) {
            return "Subaward " + ((SubAward) getData()).getSubAwardId();
        }
        else if (getData() instanceof Negotiation) {
            return "Negotiation " + ((Negotiation) getData()).getNegotiationId();
        }
        else {
    		return "---";
    	}
    }
    
    
}     
