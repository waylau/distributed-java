package com.waylau.axon.cqrs.command.commands;

import com.waylau.axon.cqrs.common.domain.AccountId;

/**
 * Create Account Command.
 * 
 * @since 1.0.0 2020年1月21日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class CreateAccountCommand {

    private AccountId accountId;
    private String accountName;
    private long amount;

    public CreateAccountCommand(AccountId accountId, 
    		String accountName, 
    		long amount) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.amount = amount;
    }

    public AccountId getAccountId() {
        return accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public long getAmount() {
        return amount;
    }
}
