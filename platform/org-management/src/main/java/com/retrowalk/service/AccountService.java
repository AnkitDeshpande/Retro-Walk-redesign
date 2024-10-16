package com.retrowalk.service;

import com.retrowalk.entities.Account;
import com.retrowalk.models.request.AccountRequest;

public interface AccountService {

    Account registerAccount(AccountRequest accountRequest);
}
