package com.waylau.axon.cqrs.common.events;

import com.waylau.axon.cqrs.common.domain.AccountId;

/**
 * Withdraw Money Event.
 * 
 * @since 1.0.0 2020年1月21日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class WithdrawMoneyEvent {
    private AccountId accountId;
    private long amount;

    public WithdrawMoneyEvent(AccountId accountId, long amount) {
        this.accountId = accountId;
        this.amount = amount;
    }

    public AccountId getAccountId() {
        return accountId;
    }

    public long getAmount() {
        return amount;
    }
}
