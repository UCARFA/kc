/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.service;

import org.apache.commons.lang3.StringUtils;
import org.kuali.rice.core.api.criteria.PredicateFactory;
import org.kuali.rice.core.api.criteria.QueryByCriteria;
import org.kuali.rice.core.api.criteria.QueryResults;
import org.kuali.rice.krad.bo.AdHocRoutePerson;
import org.kuali.rice.krad.bo.AdHocRouteRecipient;
import org.kuali.rice.krad.bo.AdHocRouteWorkgroup;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.service.impl.DocumentAdHocServiceImpl;

public class KcDocumentAdHocServiceImpl extends DocumentAdHocServiceImpl {

    @Override
    public void replaceAdHocsForDocument(Document document) {
        if ( document == null || StringUtils.isBlank(document.getDocumentNumber())) {
            return;
        }


        QueryResults<AdHocRoutePerson> dbAdHocRoutePersons = dataObjectService.findMatching(AdHocRoutePerson.class,
                        QueryByCriteria.Builder.fromPredicates(
                                PredicateFactory.equal("documentNumber", document.getDocumentNumber()),
                                PredicateFactory.equal("type", AdHocRoutePerson.PERSON_TYPE)));

        QueryResults<AdHocRouteWorkgroup> dbAdHocRouteWorkgroups = dataObjectService.findMatching(AdHocRouteWorkgroup.class,
                QueryByCriteria.Builder.fromPredicates(
                        PredicateFactory.equal("documentNumber", document.getDocumentNumber()),
                        PredicateFactory.equal("type", AdHocRoutePerson.WORKGROUP_TYPE)));

        // Delete persons not included in the current list
        for (AdHocRoutePerson dbAdHocRoutePerson : dbAdHocRoutePersons.getResults()) {
            boolean remove = true;

            if (document.getAdHocRoutePersons() != null) {
                for (AdHocRouteRecipient adHocRouteRecipient : document.getAdHocRoutePersons()) {
                    // if it exists in both lists don't delete
                    if (adHocRouteRecipient.getId().equals(dbAdHocRoutePerson.getId())) {
                        remove = false;
                    }
                }
            }

            if (remove) {
                dataObjectService.delete(dbAdHocRoutePerson);
            }
        }

        // Delete workgroups not included in the current list
        for (AdHocRouteWorkgroup dbAdHocRouteWorkgroup : dbAdHocRouteWorkgroups.getResults()) {
            boolean remove = true;

            if (document.getAdHocRouteWorkgroups() != null) {
                for (AdHocRouteRecipient adHocRouteRecipient : document.getAdHocRouteWorkgroups()) {
                    // if it exists in both lists don't delete
                    if (adHocRouteRecipient.getId().equals(dbAdHocRouteWorkgroup.getId())) {
                        remove = false;
                    }
                }
            }

            if (remove) {
                dataObjectService.delete(dbAdHocRouteWorkgroup);
            }
        }

        document.setAdHocRoutePersons(saveAdHocRouteRecipients(document.getDocumentNumber(), document.getAdHocRoutePersons()));
        document.getAdHocRoutePersons().forEach(AdHocRoutePerson::getPerson);

        document.setAdHocRouteWorkgroups(saveAdHocRouteRecipients(document.getDocumentNumber(), document.getAdHocRouteWorkgroups()));
        document.getAdHocRouteWorkgroups().forEach(adHocRouteWorkgroup -> adHocRouteWorkgroup.setId(adHocRouteWorkgroup.getId()));
    }
}
