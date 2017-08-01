package org.kuali.coeus.dc.questreseq;

import org.kuali.coeus.dc.common.db.ConnectionDaoService;
import org.kuali.coeus.dc.common.rice.parameter.Parameter;
import org.kuali.coeus.dc.common.rice.parameter.ParameterDao;
import org.kuali.coeus.dc.common.rice.parameter.ParameterKey;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static org.kuali.coeus.dc.common.db.PreparedStatementUtils.setString;
import static org.kuali.coeus.dc.common.db.PreparedStatementUtils.setLong;
import static org.kuali.coeus.dc.common.db.PreparedStatementUtils.setInt;

public class QuestReseqDaoImpl implements QuestReseqDao {

    private static final Logger LOG = Logger.getLogger(QuestReseqDaoImpl.class.getName());

    private static final Map<Integer, String> QUESTIONS;
    private static final String COMMA = ",";

    static {
        QUESTIONS = new HashMap<>();

        QUESTIONS.put(10001,"Does this project involve human subjects?");
        QUESTIONS.put(10001,"Does your project involve the use of human subjects?");
        QUESTIONS.put(10002,"Does this project involve animal subjects?");
        QUESTIONS.put(10003,"Are you involved in recruiting and/or obtaining consent of human subjects to participate in this study?");
        QUESTIONS.put(10004,"Will the entity provide a drug, device, vaccine or procedure for use in the protocol?");
        QUESTIONS.put(10005,"Are you the inventor of any drug, device, vaccine or procedure associated with this protocol?");
        QUESTIONS.put(10006,"Will Non-University Investigators be involved with the PI or Co-PI in the design, conduct or reporting of the activities associated with the project (e.g., subcontractors, consultants, others with significant responsibilities)?");
        QUESTIONS.put(10007,"Please explain where we can find the institutions' policies that indicate compliance with the funding agency's regulations.  You may also attach materials and enter \"See attached\".");
        QUESTIONS.put(10008,"Please indicate the protocol number.");
        QUESTIONS.put(10009,"Please indicate the name of the drug, device, vaccine or procedure.");
        QUESTIONS.put(10010,"Are you a consultant with this entity?");
        QUESTIONS.put(10011,"Do you have a written consulting agreement (non-University agreement) with this entity?  If yes, please attach a copy of the agreement to this report.");
        QUESTIONS.put(10012,"Please describe in detail the frequency and nature of your consulting activities with this entity.");
        QUESTIONS.put(10013,"Will the terms of your consulting in any way restrict the release of information or other dissemination of research results by faculty/researchers involved in the project?");
        QUESTIONS.put(10014,"Do you, your spouse, registered domestic partner, or any dependent child(ren) hold a position of management or employment with this entity?");
        QUESTIONS.put(10015,"Please indicate the positions held.");
        QUESTIONS.put(10016,"Please describe the responsibilities of your position(s) with the entity and how they relate to the project funded by the entity.");
        QUESTIONS.put(10017,"Do you, your spouse, registered domestic partner, or any dependent child(ren) hold an equity interest in this entity?");
        QUESTIONS.put(10018,"Please indicate the type of equity interest that you, your spouse, registered domestic partner, or any dependent child(ren) have in this entity.");
        QUESTIONS.put(10019,"Is the equity publicly traded?");
        QUESTIONS.put(10020,"What is the current total market value of the equity you, your spouse, registered domestic partner, and any dependent children hold in this entity?");
        QUESTIONS.put(10021,"Please provide an internal estimate of the value of the equity.");
        QUESTIONS.put(10022,"Please indicate the total percentage of equity held in this entity.");
        QUESTIONS.put(10023,"For non-governmental sponsored projects, is the entity supporting full direct and indirect costs of this project? If a gift or Material Transfer Agreement indicate \"Not Applicable.\"");
        QUESTIONS.put(10024,"List any other entity funding this research and their amount of support. Also identify any University funds that will be supplementing the project.");
        QUESTIONS.put(10025,"Will the research be conducted in the entity's facilities?");
        QUESTIONS.put(10026,"How many hours per week will be spent in the entity's facilities?");
        QUESTIONS.put(10027,"Will any of the entity's personnel work on the research?");
        QUESTIONS.put(10028,"Please explain what the entities' personnel will be doing on the research.");
        QUESTIONS.put(10029,"Please indicate the amount received in the past 12 months.");
        QUESTIONS.put(10030,"Please explain.");
        QUESTIONS.put(10031,"Have you received honoraria income from the entity?");
        QUESTIONS.put(10032,"Please describe the nature and frequency of your activities with this entity.");
        QUESTIONS.put(10033,"Are your activities with this entity related to the subject of the proposed research?");
        QUESTIONS.put(10034,"Please describe how activities with this entity are related to the subject of the proposed research.");
        QUESTIONS.put(10035,"Is entity a subcontractor, consortium member, supplier of goods, lessor, or otherwise involved with the project?");
        QUESTIONS.put(10036,"Please explain how they are involved with the project.");
        QUESTIONS.put(10037,"Are you receiving any supplementation from other sources? (sabbatical leave, salary, etc?)");
        QUESTIONS.put(10038,"Does the entity manufacture or commercialize any device, vaccine, procedure, drug or any other product associated with this research?");
        QUESTIONS.put(10039,"Please explain what the entity does that is associated with this research.");
        QUESTIONS.put(10040,"Is it reasonable to anticipate that the entity will be, or could be, directly and significantly affected by the design, conduct or reporting of the research activity?");
        QUESTIONS.put(10041,"Please explain how the entity might be impacted by the design, conduct or reporting of the research activity.");
        QUESTIONS.put(10042,"Is the entity a non-profit foundation?");
        QUESTIONS.put(10043,"Do you have a financial interest in the company(ies) that is (are) providing funds to this non-profit foundation?");
        QUESTIONS.put(10044,"If the sponsoring foundation is primarily a vehicle for one or two companies or a closely cooperating group of businesses, please identify these firms:");
        QUESTIONS.put(10045,"Will the project purchase/lease any device/material from the entity?");
        QUESTIONS.put(10046,"Please provide name of any devices/materials and approximate cost.");
        QUESTIONS.put(10047,"Excluding gifts, contracts or grants administered by the University, have you, your spouse, registered domestic partner or dependent child(ren) received income from this entity in the past 12 months?");
        QUESTIONS.put(10048,"Please indicate the nature of income you received from this entity.");
        QUESTIONS.put(10049,"Please explain how you are keeping your interests and obligations to the entity separate from your University activities.");
        QUESTIONS.put(10050,"Were you part of a formal committee/body that made the decision which led to the award?");
        QUESTIONS.put(10051,"Were you present when the decision which led to the award was made?");
        QUESTIONS.put(10052,"Please describe the proceedings or enter \"see attachment\" and upload a copy of the minutes.");
        QUESTIONS.put(10053,"Does the project involves testing of any drugs or devices or the development of a product?");
        QUESTIONS.put(10054,"Briefly describe the research project (or enter \"see attachment\" and upload a statement of work/abstract).");
        QUESTIONS.put(10055,"Provide a detailed description of the research project (or enter \"see attachment\" and upload a statement of work/abstract).");
        QUESTIONS.put(10056,"Is the entity providing any proprietary data, materials or equipment?");
        QUESTIONS.put(10057,"Explain what control on access to the research will be necessary.");
        QUESTIONS.put(10058,"Does the entity participate in deciding the direction of the research?");
        QUESTIONS.put(10059,"Please explain what role the entity will play in participating or deciding the direction of the research.");
        QUESTIONS.put(10060,"For non-governmental sponsored projects: Will the contract, grant or gift that will fund this research require the granting of an exclusive license or option to the entity?");
        QUESTIONS.put(10061,"Please explain how it is documented in a research agreement or clinical trial agreement:");
        QUESTIONS.put(10062,"Does the entity hold rights in a pending patent application/issued patent/copyright in which you, your spouse, registered domestic partner, or domestic child(ren) are inventor(s)/author(s)?");
        QUESTIONS.put(10063,"Has the entity licensed rights from the University?");
        QUESTIONS.put(10064,"Please indicate the invention/copyright disclosure number.");
        QUESTIONS.put(10065,"Does the entity have ownership rights?");
        QUESTIONS.put(10066,"Please explain how the entity acquired ownership rights.");
        QUESTIONS.put(10067,"Does the entity have ownership rights on existing intellectual property?");
        QUESTIONS.put(10068,"Are any undergraduate, graduate or postdoctoral students involved in the project?");
        QUESTIONS.put(10069,"How many undergraduates, graduates and/or postdocs are involved and in what capacity?");
        QUESTIONS.put(10070,"Are there any constraints or restrictions imposed on the reporting of student work?");
        QUESTIONS.put(10071,"Are you the advisor to any of these students?");
        QUESTIONS.put(10072,"Do you hold a position (such as board member, scientific advisor, director, officer, partner, trustee or employee) with any single business entity that could reasonably appear to benefit by the proposed research?");
        QUESTIONS.put(10073,"Do you have an equity interest (stock, stock options, real estate, investment or other ownership) with any single business entity that could reasonably appear to benefit by the proposed research?");
        QUESTIONS.put(10074,"Do you receive income (such as consulting fees, honoraria, travel reimbursement, or other income) from any single business entity that could reasonably appear to benefit by the proposed research?");
        QUESTIONS.put(10075,"Do you have rights to a pending application or issued patent to an invention(s), license rights, or copyright for software that has a direct relationship to the project?");
        QUESTIONS.put(10076,"State:");
        QUESTIONS.put(10077,"Country:");
        QUESTIONS.put(10078,"Start Date:");
        QUESTIONS.put(10079,"End Date:");
        QUESTIONS.put(10080,"Please indicate the protocol number.");
        QUESTIONS.put(10085,"Can you certify that the information submitted within this application is true, complete and accurate to the best of your knowledge? That any false, fictitious, or fraudulent statements or claims may subject you, as the PI/Co-PI/Co-I to criminal, civil or administrative penalties? That you agree to accept responsibility for the scientific conduct of the project and to provide the required progress reports if an award is made as a result of this application.");
        QUESTIONS.put(10086,"Is there any potential for a perceived or real conflict of interest as defined in MIT's Policies and Procedures with regard to this proposal?");
        QUESTIONS.put(10087,"If this is a NIH/NSF proposal have you submitted the required financial disclosures in the web based Coeus Conflict of Interest module?");
        QUESTIONS.put(10088,"Have lobbying activities been conducted on behalf of this proposal?");
        QUESTIONS.put(10089,"Are you currently debarred, suspended, proposed for debarment, declared ineligible or voluntarily excluded from current transactions by a federal department or agency?");
        QUESTIONS.put(10100,"Are you familiar with the requirements of the Procurement Liabilities Act?");
        QUESTIONS.put(10110,"Have lobbying activities been conducted on behalf of this proposal? Disclosure of Lobbying Activities (PAPPG Chapter II.C.1.d and Exhibit II-5)");
        QUESTIONS.put(10111,"Are you an NSF Beginning Investigator? (Proposal & Award Policies & Procedures Guide (PAPPG) Chapter II.D.2)");
        QUESTIONS.put(10112,"Is this proposal an NSF Accomplishment Based renewal? (PAPPG Chapter V.B)");
        QUESTIONS.put(10115,"Select a Funding Mechanism");
        QUESTIONS.put(10120,"Do the instructions for this project indicate this is a restricted program?");
    }

    private static final String SELECT_QUESTIONNAIRES_WITH_QUESTION = "select questionnaire_id from questionnaire i1 " +
            "inner join questionnaire_questions i2 " +
            "on i1.QUESTIONNAIRE_REF_ID = i2.QUESTIONNAIRE_REF_ID_FK " +
            "inner join question i3 " +
            "on i3.QUESTION_REF_ID = i2.QUESTION_REF_ID_FK " +
            "where i3.QUESTION_ID = ? " +
            " and i3.QUESTION = ?";

    private static final String SELECT_TERM_FOR_QUESTION = "select r.term_id, r.question_id, r.questionnaire_id from (select term_id, max(question_id) question_id, max(questionnaire_id) questionnaire_id from " +
            "(select u1.term_id, " +
            "CASE WHEN u1.nm = 'Question Seq ID' THEN u1.val ELSE null end question_id, " +
            "CASE WHEN u1.nm = 'Questionnaire Seq ID' THEN u1.val ELSE null end questionnaire_id  " +
            "FROM krms_term_parm_t u1 " +
            "inner join krms_term_t u2 " +
            "on u1.term_id = u2.term_id " +
            "and u2.term_spec_id in ('KC1016', 'KC1026', 'KC1027', 'KC1028', 'KC1029')) q " +
            "GROUP BY q.term_id) r " +
            "where r.question_id = ? and r.questionnaire_id = ?";

    private static final String UPDATE_TERM = "update krms_term_parm_t set val = ? where nm = 'Question Seq ID' and term_id = ?";

    private static final String UPDATE_QUESTION_ID = "update QUESTION set QUESTION_ID = ? where QUESTION_ID = ? and question = ?";

    private static final String BACKUP_KRMS_TERM_PARM_T = "create table krms_term_parm_t_bak07312017 as select * from krms_term_parm_t";
    private static final String BACKUP_QUESTION = "create table question_bak07312017 as select * from question";


    private static final ParameterKey PARAMETER_KEY = new ParameterKey("KC-GEN", "All", "PROP_PERSON_COI_CERTIFY_QID", "KC");

    private ConnectionDaoService connectionDaoService;
    private ParameterDao parameterDao;

    @Override
    public void resequenceQuestions() {
        try(PreparedStatement backupTerms = getConnectionDaoService().getRiceConnection().prepareStatement(BACKUP_KRMS_TERM_PARM_T);
            PreparedStatement backupQuestions = getConnectionDaoService().getCoeusConnection().prepareStatement(BACKUP_QUESTION)){
            backupTerms.execute();
            backupQuestions.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        QUESTIONS.forEach((questionSeqId, question) -> {
            try (PreparedStatement selectQuestionnaires = setString(2, question, setInt(1, questionSeqId, getConnectionDaoService().getCoeusConnection().prepareStatement(SELECT_QUESTIONNAIRES_WITH_QUESTION)));
                 PreparedStatement updateQuestion = setString(3, question, setInt(2, questionSeqId, setInt(1, (questionSeqId * -1), getConnectionDaoService().getCoeusConnection().prepareStatement(UPDATE_QUESTION_ID))))) {

                try (ResultSet selectQuestionnairesResult = selectQuestionnaires.executeQuery()) {
                    while (selectQuestionnairesResult.next()) {
                        final Integer questionnaireId = selectQuestionnairesResult.getInt(1);
                        try (PreparedStatement selectTerms = setInt(2, questionnaireId, setInt(1, questionSeqId, getConnectionDaoService().getRiceConnection().prepareStatement(SELECT_TERM_FOR_QUESTION)));
                             ResultSet selectTermsResult = selectTerms.executeQuery()) {
                            while (selectTermsResult.next()) {
                                final Long termId = selectTermsResult.getLong(1);
                                try (PreparedStatement updateTerms = setLong(2, termId, setInt(1, (questionSeqId * -1), getConnectionDaoService().getRiceConnection().prepareStatement(UPDATE_TERM)))) {
                                    updateTerms.executeUpdate();
                                }
                            }
                        }
                    }
                }
                updateCertifyQidParameter();

                updateQuestion.executeUpdate();
            } catch (SQLException e) {
                    throw new RuntimeException(e);
            }
        });
    }

    private void updateCertifyQidParameter() {
        final Parameter parameter = parameterDao.getParameter(PARAMETER_KEY);
        final String value = parameter.getValue();
        if (value != null && !value.trim().equals("")) {
            final String newValue = Arrays.stream(value.split(COMMA))
                    .map(qid -> {
                        try {
                            if (QUESTIONS.containsKey(Integer.valueOf(qid.trim()))) {
                                return Integer.toString((Integer.valueOf(qid.trim()) * -1));
                            }
                        } catch (NumberFormatException e) {
                            LOG.warning(PARAMETER_KEY + " contains a value that is not an integer " + value);
                        }
                        return qid.trim();
                    })
                    .collect(Collectors.joining(COMMA));

            if (!value.equals(newValue)) {
                parameterDao.updateParameter(PARAMETER_KEY, newValue);
            }
        }
    }


    public ConnectionDaoService getConnectionDaoService() {
        return connectionDaoService;
    }

    public void setConnectionDaoService(ConnectionDaoService connectionDaoService) {
        this.connectionDaoService = connectionDaoService;
    }

    public ParameterDao getParameterDao() {
        return parameterDao;
    }

    public void setParameterDao(ParameterDao parameterDao) {
        this.parameterDao = parameterDao;
    }
}
