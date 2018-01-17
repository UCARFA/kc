/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.coi.impl;



import com.fasterxml.jackson.databind.ObjectMapper;
import org.kuali.coeus.coi.framework.Project;
import org.kuali.coeus.coi.framework.ProjectPublisher;
import org.kuali.coeus.sys.framework.mq.Producer;
import org.kuali.coeus.sys.framework.mq.rest.HttpMethod;
import org.kuali.coeus.sys.framework.mq.rest.RestRequest;
import org.kuali.kra.infrastructure.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Set;

@Component("projectPublisher")
public class ProjectPublisherImpl implements ProjectPublisher {

    @Autowired
    @Qualifier("restMessageProducer")
    private Producer<RestRequest> restMessageProducer;

    @Autowired
    @Qualifier("beanValidator")
    private Validator validator;

    @Override
    public void publishProject(Project project) {
        final Set<ConstraintViolation<Project>> violations = validator.validate(project);
        if (!violations.isEmpty()){
            throw new IllegalArgumentException(violations.toString());
        }

        final RestRequest request = new RestRequest();
        request.setDestination(Constants.COI_PROJECTS);
        request.setHeaders(Collections.singletonMap(Constants.CONTENT_TYPE, Collections.singletonList(Constants.APPLICATION_JSON)));
        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            objectMapper.setDateFormat(format);
            request.setBody(objectMapper.writeValueAsString(project));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        request.setMethod(HttpMethod.POST);

        restMessageProducer.sendMessage(request);
    }

    public Producer<RestRequest> getRestMessageProducer() {
        return restMessageProducer;
    }

    public void setRestMessageProducer(Producer<RestRequest> restMessageProducer) {
        this.restMessageProducer = restMessageProducer;
    }

    public Validator getValidator() {
        return validator;
    }

    public void setValidator(Validator validator) {
        this.validator = validator;
    }
}
