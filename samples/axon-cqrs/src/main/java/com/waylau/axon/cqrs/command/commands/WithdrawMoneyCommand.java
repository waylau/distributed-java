package com.waylau.axon.cqrs.command.commands;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import com.waylau.axon.cqrs.common.domain.AccountId;

/**
 * Withdraw Money Command.
 * 
 * @since 1.0.0 2020年1月21日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class WithdrawMoneyCommand {

    @TargetAggregateIdentifier
    private AccountId accountId;
    private long amount;


    public WithdrawMoneyCommand(AccountId accountId, long amount) {
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
