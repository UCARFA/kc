/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.auth.task;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.InitializingBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.Map;

/**
 * A Web Authorizer maps to a Struts Action class where one or more its methods
 * requires authorization.
 */
public class WebAuthorizer implements InitializingBean {

    private String classname;
    private Map<String, WebTaskFactory> mappings;
    
    /**
     * Set the name of the Struts Action class that requires authorization.  Injected
     * by the Spring Framework.
     * @param classname the Struts Action classname
     */
    public void setClassname(String classname) {
        this.classname = classname;
    }
    
    /**
     * Set the mappings.  Each entry in the map correlates a Struts Action method
     * to a Task Factory.  When the action method is to be invoked, it's Task Factory
     * is used to build a Task.  That Task is then used to determine if the user is
     * allowed to perform that task.  This mapping is injected by the Spring Framework.
     * @param mappings the set of mappings of Struts Action methods to Task Factories
     */
    public void setMappings(Map<String, WebTaskFactory> mappings) {
        this.mappings = mappings;
    }
    
    /**
     * Get the Struts Action classname.
     * @return the Struts Action classname
     */
    public String getClassname() {
        return classname;
    }

    /**
     * Get the Task Factory for a particular Struts Action method.
     * @param methodName the name of the Struts Action method
     * @return the corresponding Task Factory or null if not found
     */
    public WebTaskFactory getTaskFactory(String methodName) {
        return mappings.get(methodName);
    }

    /**
     * To prevent errors in SpringBeans.xml, we must verify that the specified
     * classname and its methods are actually present in the code.  By using
     * the Java methods forName() and getDeclaredMethod(), an exception is thrown
     * if the class or method does not exist.
     * 
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        
        Class clazz = Class.forName(classname);
        
        Iterator<String> iter = mappings.keySet().iterator();
        while (iter.hasNext()) {
            String methodName = iter.next();
            clazz.getDeclaredMethod(methodName, ActionMapping.class, ActionForm.class, HttpServletRequest.class, HttpServletResponse.class);
        }
    }
}
