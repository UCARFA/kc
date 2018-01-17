/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.controller.interceptor;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.coeus.common.framework.multicampus.MultiCampusConstants;
import org.kuali.rice.krad.util.AuditCluster;
import org.kuali.rice.kns.util.KNSConstants;
import org.kuali.rice.kns.web.struts.action.KualiRequestProcessor;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.util.KRADConstants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * <p>
 * This class handles setup of user session and restoring of action form.
 * </p>
 * 
 * <p>
 * This class also sorts the Audit Map In the HttpServletRequest
 * </p>
 */
public class KcRequestProcessor extends KualiRequestProcessor {
    
    @Override
    protected boolean processPreprocess(HttpServletRequest request, HttpServletResponse response) {
        super.processPreprocess(request, response);
        
        Object campusCode = request.getSession().getAttribute(MultiCampusConstants.USER_CAMPUS_CODE_KEY);
        GlobalVariables.getUserSession().addObject(MultiCampusConstants.USER_CAMPUS_CODE_KEY, campusCode);
        
        return true;
    }

    @Override
    protected ActionForward processActionPerform(final HttpServletRequest request,
        final HttpServletResponse response, final Action action, final ActionForm form,
        final ActionMapping mapping) throws IOException, ServletException {
        
        final ActionForward actionForward;
        
        if (this.isSessionExpired(request)) {
            final HttpSession session = request.getSession();
            session.removeAttribute(KeyConstants.SESSION_EXPIRED_IND);
            actionForward = mapping.findForward(KRADConstants.MAPPING_PORTAL); 
        } else {
            actionForward = super.processActionPerform(request, response, action, form, mapping);
            //must come after call to super because the super class sets audit map in request
            this.sortAuditMapInRequest(request);
        }
        
        return actionForward;
    }  
    
    @Override
    protected void processPopulate(HttpServletRequest request, HttpServletResponse response, ActionForm form,
        ActionMapping mapping) throws ServletException {

        if (!this.isSessionExpired(request)) {
            super.processPopulate(request, response, form, mapping);
        }
    }

    /**
     * This method checks if session is expired
     * (according to the {@link KeyConstants#SESSION_EXPIRED_IND KeyConstants.SESSION_EXPIRED_IND}).
     * @param request the HttpServletRequest
     * @return true if expired
     */
    private boolean isSessionExpired(final HttpServletRequest request) {
        assert request != null : "the request is null";
        
        final HttpSession session = request.getSession();
        final Boolean sessionExpired = (Boolean) session.getAttribute(KeyConstants.SESSION_EXPIRED_IND);
        //null means it is not expired...
        return Boolean.TRUE.equals(sessionExpired);
    }
    
    /**
     * This method retrieves the audit map from the http request.
     * 
     * @param request the HttpServletRequest
     * @return the audit map.  If not present this method will return null.
     */
    private Map<String, AuditCluster> getAuditMap(final HttpServletRequest request) {
        assert request != null : "the request is null";
        
        @SuppressWarnings("unchecked")
        final Map<String, AuditCluster> auditErrorsMap
            = (Map<String, AuditCluster>) request.getAttribute(KNSConstants.AUDIT_ERRORS);
        
        return auditErrorsMap;
    }
    
    /**
     * Sorts the audit map in the request.
     * @param request the HttpServletRequest
     */
    private void sortAuditMapInRequest(final HttpServletRequest request) {
        assert request != null : "the request is null";
        
        final Map<String, AuditCluster> auditMap = getAuditMap(request);
        if (auditMap != null) {
            AuditMapSorter sorter = new AuditMapSorter(auditMap);
            sorter.sort(AuditMapSorter.DEFAULT_PATTERN_COMPARATOR_MAP);
        }
    }
}
