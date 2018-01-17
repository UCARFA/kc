/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.sponsor;

import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.sponsor.SponsorSearchResult;
import org.kuali.coeus.common.framework.sponsor.SponsorSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Service("sponsorSearchService")
public class SponsorSearchServiceImpl implements SponsorSearchService {

    @Autowired
    @Qualifier("kcEntityManager")
    private EntityManager entityManager;

    @Override
    public List<SponsorSearchResult> findSponsors(String searchString) {
        if (StringUtils.isBlank(searchString)) {
            throw new IllegalArgumentException("searchString is blank");
        }

        final String likeCriteria = "%" + searchString.toUpperCase() + "%";
        TypedQuery<SponsorSearchResult> query = entityManager.createQuery(
                "SELECT NEW org.kuali.coeus.common.framework.sponsor.SponsorSearchResult(t.sponsorCode, t.sponsorName) " +
                        "FROM Sponsor t " +
                        "WHERE UPPER(t.sponsorCode) like :likeCriteria OR UPPER(t.acronym) like :likeCriteria or UPPER(t.sponsorName) like :likeCriteria", SponsorSearchResult.class)
                .setParameter("likeCriteria", likeCriteria);

        return ListUtils.emptyIfNull(query.setMaxResults(25).getResultList());
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
