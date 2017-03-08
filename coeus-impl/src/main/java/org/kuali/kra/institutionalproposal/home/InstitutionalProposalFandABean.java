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
package org.kuali.kra.institutionalproposal.home;

import org.kuali.kra.institutionalproposal.document.InstitutionalProposalDocument;
import org.kuali.kra.institutionalproposal.web.struts.form.InstitutionalProposalForm;

import java.io.Serializable;


public class InstitutionalProposalFandABean implements Serializable {

    private static final long serialVersionUID = -4162806132355841770L;

    private InstitutionalProposalForm parent;

    private InstitutionalProposalFandA newInstitutionalProposalFandA;

    public InstitutionalProposalFandABean() {
        super();
        newInstitutionalProposalFandA = new InstitutionalProposalFandA();
    }

    public InstitutionalProposalFandABean(InstitutionalProposalForm parent) {
        this.parent = parent;
        newInstitutionalProposalFandA = new InstitutionalProposalFandA();
    }

    public void init() {
        newInstitutionalProposalFandA = new InstitutionalProposalFandA();
    }

    public InstitutionalProposalFandA getNewInstitutionalProposalFandA() {
        return newInstitutionalProposalFandA;
    }

    public void setnewInstitutionalProposalFandA(InstitutionalProposalFandA newInstitutionalProposalFandA) {
        this.newInstitutionalProposalFandA = newInstitutionalProposalFandA;
    }

    public InstitutionalProposalDocument getInstitutionalProposalDocument() {
        return parent.getInstitutionalProposalDocument();
    }

    public Object getData() {
        return getNewInstitutionalProposalFandA();
    }

    public boolean addFandA(InstitutionalProposalFandABean formBean) throws Exception {
                formBean.getInstitutionalProposalDocument().getInstitutionalProposal().add(formBean.getNewInstitutionalProposalFandA());
                formBean.init();
                return true;
    }
}
