/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.award.api;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import org.kuali.coeus.sys.framework.controller.rest.SimpleCrudMapBasedRestController;
import org.kuali.coeus.sys.framework.rest.ResourceNotFoundException;
import org.kuali.coeus.sys.framework.rest.SearchResults;
import org.kuali.kra.award.dao.AwardDao;
import org.kuali.kra.award.home.Award;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import com.codiform.moo.curry.Translate;

public class AwardControllerVersion1 extends SimpleCrudMapBasedRestController<Award> {

    @Autowired
    @Qualifier("awardDao")
    private AwardDao awardDao;

    @RequestMapping(params="summary", method=RequestMethod.GET)
    public @ResponseBody AwardResults getAwardSummary(@RequestParam(value="updatedSince", required=false) Instant updatedSince,
                                                      @RequestParam(value="page", required=false) Integer page, @RequestParam(value="limit", required=false) Integer limit) {
        assertMethodSupported(RequestMethod.GET);
        assertUserHasReadAccess();
        AwardResults result = Translate.to(AwardResults.class).from(getAwards(updatedSince == null ? null : Date.from(updatedSince), page, limit));
        if (result == null || result.getCount() == null || result.getCount() == 0) {
            throw new ResourceNotFoundException("not found");
        }
        return result;
    }

    SearchResults<Award> getAwards(Date updatedSince, Integer page, Integer numberPerPage) {
        return getAwardDao().retrieveActiveAwardsByCriteria(new HashMap<>(), updatedSince, page, numberPerPage);
    }

    public AwardDao getAwardDao() {
        return awardDao;
    }

    public void setAwardDao(AwardDao awardDao) {
        this.awardDao = awardDao;
    }
}
