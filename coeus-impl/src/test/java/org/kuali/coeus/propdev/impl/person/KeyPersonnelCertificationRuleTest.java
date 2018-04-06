package org.kuali.coeus.propdev.impl.person;

import jdk.nashorn.internal.objects.Global;
import org.junit.Assert;
import org.junit.Test;
import org.kuali.coeus.common.framework.person.PropAwardPersonRole;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.sys.framework.gv.GlobalVariableService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.rice.krad.UserSession;
import org.kuali.rice.krad.util.GlobalVariables;

import java.util.List;

public class KeyPersonnelCertificationRuleTest {

    @Test
    public void testPiandCoiNeedCert() {
        KeyPersonnelCertificationRule rule =
                new KeyPersonnelCertificationRule() {
                    public boolean doesNonEmployeeHaveCertification(List<ProposalPerson> proposalPersons) {
                        return true;
                    }

                    protected String getKeyPersonCertDeferralParm() {
                        return "BS";
                    }

                    protected boolean validKeyPersonCertification(ProposalPerson person) {
                        return false;
                    }
                };

        ProposalDevelopmentDocument pdDoc = new ProposalDevelopmentDocument();
        DevelopmentProposal pd = new DevelopmentProposal();
        pdDoc.setDevelopmentProposal(pd);

        ProposalPerson coi = new ProposalPerson() {
            public PropAwardPersonRole getRole() {
                PropAwardPersonRole personRole = new PropAwardPersonRole();
                personRole.setCode(Constants.CO_INVESTIGATOR_ROLE);
                personRole.setCertificationRequired(true);
                return personRole;
            }
        };

        ProposalPerson pi = new ProposalPerson() {
            public PropAwardPersonRole getRole() {
                PropAwardPersonRole personRole = new PropAwardPersonRole();
                personRole.setCode(Constants.PRINCIPAL_INVESTIGATOR_ROLE);
                personRole.setCertificationRequired(true);
                return personRole;
            }
        };
        pd.getProposalPersons().add(coi);
        pd.getProposalPersons().add(pi);

        Assert.assertFalse(noCertificationRequired(rule, pdDoc));
    }

    public boolean noCertificationRequired(KeyPersonnelCertificationRule rule, ProposalDevelopmentDocument pdDoc) {
        return rule.processRunAuditBusinessRules(pdDoc);
    }

    @Test
    public void testCoiDoesNotNeedCert() {
        KeyPersonnelCertificationRule rule =
                new KeyPersonnelCertificationRule() {
                    public boolean doesNonEmployeeHaveCertification(List<ProposalPerson> proposalPersons) {
                        return true;
                    }

                    protected String getKeyPersonCertDeferralParm() {
                        return "BS";
                    }

                    protected boolean validKeyPersonCertification(ProposalPerson person) {
                        return false;
                    }
                };

        ProposalDevelopmentDocument pdDoc = new ProposalDevelopmentDocument();
        DevelopmentProposal pd = new DevelopmentProposal();
        pdDoc.setDevelopmentProposal(pd);

        ProposalPerson coi = new ProposalPerson() {
            public PropAwardPersonRole getRole() {
                PropAwardPersonRole personRole = new PropAwardPersonRole();
                personRole.setCode(Constants.CO_INVESTIGATOR_ROLE);
                personRole.setCertificationRequired(false);
                return personRole;
            }
        };

        pd.getProposalPersons().add(coi);
        Assert.assertTrue(noCertificationRequired(rule, pdDoc));

        ProposalPerson pi = new ProposalPerson() {
            public PropAwardPersonRole getRole() {
                PropAwardPersonRole personRole = new PropAwardPersonRole();
                personRole.setCode(Constants.PRINCIPAL_INVESTIGATOR_ROLE);
                personRole.setCertificationRequired(false);
                return personRole;
            }
        };

        pd.getProposalPersons().add(pi);
        Assert.assertTrue(noCertificationRequired(rule, pdDoc));

    }

    @Test
    public void testPiandCoiNeedCertRolodexDoesNotNeedCert() {
        KeyPersonnelCertificationRule rule =
                new KeyPersonnelCertificationRule() {
                    public boolean doesNonEmployeeHaveCertification(List<ProposalPerson> proposalPersons) {
                        return false;
                    }

                    protected String getKeyPersonCertDeferralParm() {
                        return "BS";
                    }

                    protected boolean validKeyPersonCertification(ProposalPerson person) {
                        return false;
                    }
                };

        ProposalDevelopmentDocument pdDoc = new ProposalDevelopmentDocument();
        DevelopmentProposal pd = new DevelopmentProposal();
        pdDoc.setDevelopmentProposal(pd);

        ProposalPerson coi = new ProposalPerson() {
            public PropAwardPersonRole getRole() {
                PropAwardPersonRole personRole = new PropAwardPersonRole();
                personRole.setCode(Constants.CO_INVESTIGATOR_ROLE);
                personRole.setCertificationRequired(true);
                return personRole;
            }
        };

        ProposalPerson pi = new ProposalPerson() {
            public PropAwardPersonRole getRole() {
                PropAwardPersonRole personRole = new PropAwardPersonRole();
                personRole.setCode(Constants.PRINCIPAL_INVESTIGATOR_ROLE);
                personRole.setCertificationRequired(true);
                return personRole;
            }
        };
        pd.getProposalPersons().add(coi);
        pd.getProposalPersons().add(pi);

        Assert.assertFalse(noCertificationRequired(rule, pdDoc));
    }

    @Test
    public void testCoiDoesNotNeedCertRolodexDoesNotNeedCert() {
        KeyPersonnelCertificationRule rule =
                new KeyPersonnelCertificationRule() {
                    public boolean doesNonEmployeeHaveCertification(List<ProposalPerson> proposalPersons) {
                        return false;
                    }

                    protected String getKeyPersonCertDeferralParm() {
                        return "BS";
                    }

                    protected boolean validKeyPersonCertification(ProposalPerson person) {
                        return false;
                    }
                };

        ProposalDevelopmentDocument pdDoc = new ProposalDevelopmentDocument();
        DevelopmentProposal pd = new DevelopmentProposal();
        pdDoc.setDevelopmentProposal(pd);

        ProposalPerson coi = new ProposalPerson() {
            public PropAwardPersonRole getRole() {
                PropAwardPersonRole personRole = new PropAwardPersonRole();
                personRole.setCode(Constants.CO_INVESTIGATOR_ROLE);
                personRole.setCertificationRequired(false);
                return personRole;
            }
        };

        pd.getProposalPersons().add(coi);
        Assert.assertFalse(noCertificationRequired(rule, pdDoc));

        ProposalPerson pi = new ProposalPerson() {
            public PropAwardPersonRole getRole() {
                PropAwardPersonRole personRole = new PropAwardPersonRole();
                personRole.setCode(Constants.PRINCIPAL_INVESTIGATOR_ROLE);
                personRole.setCertificationRequired(false);
                return personRole;
            }
        };

        pd.getProposalPersons().add(pi);
        Assert.assertFalse(noCertificationRequired(rule, pdDoc));
    }

    @Test
    public void testCoiNeedCertBA() {
        KeyPersonnelCertificationRule rule =
                new KeyPersonnelCertificationRule() {
                    public boolean doesNonEmployeeHaveCertification(List<ProposalPerson> proposalPersons) {
                        return true;
                    }

                    protected String getKeyPersonCertDeferralParm() {
                        return "BA";
                    }

                    protected boolean validKeyPersonCertification(ProposalPerson person) {
                        return false;
                    }

                    protected String getLoggedInUser() {
                        return "quickstart";
                    }
                };

        ProposalDevelopmentDocument pdDoc = new ProposalDevelopmentDocument();
        DevelopmentProposal pd = new DevelopmentProposal();
        pdDoc.setDevelopmentProposal(pd);

        ProposalPerson coi = new ProposalPerson() {
            public PropAwardPersonRole getRole() {
                PropAwardPersonRole personRole = new PropAwardPersonRole();
                personRole.setCode(Constants.CO_INVESTIGATOR_ROLE);
                personRole.setCertificationRequired(true);
                return personRole;
            }
        };
        coi.setUserName("quickstart");
        coi.setPersonId("quickstart");
        coi.setProposalPersonRoleId(Constants.CO_INVESTIGATOR_ROLE);
        pd.getProposalPersons().add(coi);

        Assert.assertFalse(noCertificationRequired(rule, pdDoc));
    }

    @Test
    public void testCoiNoNeedCertBA() {
        KeyPersonnelCertificationRule rule =
                new KeyPersonnelCertificationRule() {
                    public boolean doesNonEmployeeHaveCertification(List<ProposalPerson> proposalPersons) {
                        return true;
                    }

                    protected String getKeyPersonCertDeferralParm() {
                        return "BA";
                    }

                    protected boolean validKeyPersonCertification(ProposalPerson person) {
                        return false;
                    }

                    protected String getLoggedInUser() {
                        return "quickstart";
                    }
                };

        ProposalDevelopmentDocument pdDoc = new ProposalDevelopmentDocument();
        DevelopmentProposal pd = new DevelopmentProposal();
        pdDoc.setDevelopmentProposal(pd);

        ProposalPerson coi = new ProposalPerson() {
            public PropAwardPersonRole getRole() {
                PropAwardPersonRole personRole = new PropAwardPersonRole();
                personRole.setCode(Constants.CO_INVESTIGATOR_ROLE);
                personRole.setCertificationRequired(false);
                return personRole;
            }
        };
        coi.setUserName("quickstart");
        coi.setPersonId("quickstart");
        coi.setProposalPersonRoleId(Constants.CO_INVESTIGATOR_ROLE);
        pd.getProposalPersons().add(coi);

        Assert.assertTrue(noCertificationRequired(rule, pdDoc));
    }

    @Test
    public void testRolodexNoCertCoiNeedCertBA() {
        KeyPersonnelCertificationRule rule =
                new KeyPersonnelCertificationRule() {
                    public boolean doesNonEmployeeHaveCertification(List<ProposalPerson> proposalPersons) {
                        return false;
                    }

                    protected String getKeyPersonCertDeferralParm() {
                        return "BA";
                    }

                    protected boolean validKeyPersonCertification(ProposalPerson person) {
                        return false;
                    }

                    protected String getLoggedInUser() {
                        return "quickstart";
                    }
                };

        ProposalDevelopmentDocument pdDoc = new ProposalDevelopmentDocument();
        DevelopmentProposal pd = new DevelopmentProposal();
        pdDoc.setDevelopmentProposal(pd);

        ProposalPerson coi = new ProposalPerson() {
            public PropAwardPersonRole getRole() {
                PropAwardPersonRole personRole = new PropAwardPersonRole();
                personRole.setCode(Constants.CO_INVESTIGATOR_ROLE);
                personRole.setCertificationRequired(true);
                return personRole;
            }
        };
        coi.setUserName("quickstart");
        coi.setPersonId("quickstart");
        coi.setProposalPersonRoleId(Constants.CO_INVESTIGATOR_ROLE);
        pd.getProposalPersons().add(coi);

        Assert.assertFalse(noCertificationRequired(rule, pdDoc));
    }

    @Test
    public void testRolodexNoCertCoiNoNeedCertBA() {
        KeyPersonnelCertificationRule rule =
                new KeyPersonnelCertificationRule() {
                    public boolean doesNonEmployeeHaveCertification(List<ProposalPerson> proposalPersons) {
                        return false;
                    }

                    protected String getKeyPersonCertDeferralParm() {
                        return "BA";
                    }

                    protected boolean validKeyPersonCertification(ProposalPerson person) {
                        return false;
                    }

                    protected String getLoggedInUser() {
                        return "quickstart";
                    }
                };

        ProposalDevelopmentDocument pdDoc = new ProposalDevelopmentDocument();
        DevelopmentProposal pd = new DevelopmentProposal();
        pdDoc.setDevelopmentProposal(pd);

        ProposalPerson coi = new ProposalPerson() {
            public PropAwardPersonRole getRole() {
                PropAwardPersonRole personRole = new PropAwardPersonRole();
                personRole.setCode(Constants.CO_INVESTIGATOR_ROLE);
                personRole.setCertificationRequired(false);
                return personRole;
            }
        };
        coi.setUserName("quickstart");
        coi.setPersonId("quickstart");
        coi.setProposalPersonRoleId(Constants.CO_INVESTIGATOR_ROLE);
        pd.getProposalPersons().add(coi);

        Assert.assertFalse(noCertificationRequired(rule, pdDoc));
    }

}




