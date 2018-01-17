/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.award.finance;

import com.codiform.moo.curry.Translate;

import org.kuali.coeus.award.dto.AwardDto;
import org.kuali.coeus.award.finance.dao.AccountDao;
import org.kuali.coeus.common.api.document.service.CommonApiService;
import org.kuali.coeus.sys.framework.controller.rest.RestController;
import org.kuali.coeus.sys.framework.rest.ResourceNotFoundException;
import org.kuali.coeus.sys.framework.rest.SearchResults;
import org.kuali.kra.award.dao.AwardDao;
import org.kuali.kra.award.home.Award;
import org.kuali.rice.krad.data.DataObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequestMapping(value="/api")
@Controller("awardAccountController")
public class AwardAccountController extends RestController {

    public static final String NO_SUCH_ACCOUNT = "No such account.";
    @Autowired
    @Qualifier("accountDao")
    private AccountDao accountDao;

    @Autowired
    @Qualifier("dataObjectService")
    private DataObjectService dataObjectService;

    @Autowired
    @Qualifier("awardDao")
    private AwardDao awardDao;

    @Autowired
    @Qualifier("commonApiService")
    private CommonApiService commonApiService;

    @RequestMapping(value="/v1/accounts")
    public @ResponseBody
    AccountResults getAccounts(@RequestParam(value = "startIndex", required = false) Integer startIndex,
                                     @RequestParam(value = "size", required = false) Integer size) {
        return Translate.to(AccountResults.class).from(transformSearchResults(getAccountDao().getAccounts(startIndex, size)));
    }

    @RequestMapping(method=RequestMethod.PUT, value="v1/accounts/{accountNumber}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(value = HttpStatus.OK)
    public
    void updateAccount(@Valid @RequestBody AccountDto account, @PathVariable String accountNumber) throws Exception {
        AwardAccount currentAccount = accountDao.getAccount(accountNumber);
        if(Objects.isNull(currentAccount)) {
            sendErrorResponse(NO_SUCH_ACCOUNT);
        } else {
            if (account.getStatus() != null) currentAccount.setStatus(account.getStatus());
            if (account.getPending() != null) currentAccount.setPending(account.getPending());
            if (account.getBudgeted() != null) currentAccount.setBudgeted(account.getBudgeted());
            if (account.getAvailable() != null) currentAccount.setAvailable(account.getAvailable());
            if (account.getExpense() != null) currentAccount.setExpense(account.getExpense());
            if (account.getIncome() != null) currentAccount.setIncome(account.getIncome());
            if (account.getComment() != null) currentAccount.setComment(account.getComment());

            accountDao.saveAccount(currentAccount);
        }
    }

    @RequestMapping(method=RequestMethod.GET, value="v1/accounts/{accountNumber}")
    public @ResponseBody
    AccountResults getAccount(@PathVariable String accountNumber) throws Exception {
        AwardAccount account = accountDao.getAccount(accountNumber);
        ArrayList<AwardAccount> accounts = new ArrayList<>();
        accounts.add(account);
        if(Objects.isNull(account)) {
            sendErrorResponse(NO_SUCH_ACCOUNT);
        }
        return Translate.to(AccountResults.class).from(transformSearchResults(accounts));
    }

    @RequestMapping(method= RequestMethod.GET, value="v1/award-posts",
            consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    List<AwardPostsDto> getAwardPosts(@RequestParam(value="accountNumber", required=false) String accountNumber) {
        List<AwardPosts> awardPostsList = getAccountDao().getActiveAwardPosts(accountNumber);
        return awardPostsList.stream()
                .map(awardPost -> translateAwardPosts(awardPost))
                .collect(Collectors.toList());
    }

    protected AwardPostsDto translateAwardPosts(AwardPosts awardPosts) {
        AwardPostsDto awardPostsDto = commonApiService.convertObject(awardPosts, AwardPostsDto.class);
        Award award = awardDao.getAward(awardPosts.getAwardId());
        AwardDto awardDto = commonApiService.convertAwardToDto(award);
        awardPostsDto.setAwardDto(awardDto);
        return awardPostsDto;
    }

    @RequestMapping(method= RequestMethod.PUT, value="v1/award-posts/{postId}",
            consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    AwardPostsDto getAwardPosts(@PathVariable Long postId, @RequestBody AwardPostsDto awardPostsDto) {
        AwardPosts awardPost = getAccountDao().getAwardPostsById(postId);
        if(awardPost == null) {
            throw new ResourceNotFoundException("The award post entry with id " + postId + " was not found.");
        }
        awardPost.setActive(awardPostsDto.isActive());
        dataObjectService.save(awardPost);
        return commonApiService.convertObject(awardPost, AwardPostsDto.class);
    }

    SearchResults transformSearchResults(List<AwardAccount> accounts) {
        SearchResults result = new SearchResults();
        result.setResults(accounts);
        result.setTotalResults(accounts.size());
        return result;
    }

    protected void sendErrorResponse(String msg) throws IOException {
        throw new ResourceNotFoundException(msg);
    }

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

}
