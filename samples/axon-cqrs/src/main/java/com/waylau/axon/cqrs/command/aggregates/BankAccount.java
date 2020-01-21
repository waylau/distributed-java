package com.waylau.axon.cqrs.command.aggregates;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;
import static org.slf4j.LoggerFactory.getLogger;

import java.math.BigDecimal;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventhandling.EventHandler;
import org.slf4j.Logger;

import com.waylau.axon.cqrs.command.commands.CreateAccountCommand;
import com.waylau.axon.cqrs.command.commands.WithdrawMoneyCommand;
import com.waylau.axon.cqrs.common.domain.AccountId;
import com.waylau.axon.cqrs.common.events.CreateAccountEvent;
import com.waylau.axon.cqrs.common.events.WithdrawMoneyEvent;

/**
 * Bank Account.
 * 
 * @since 1.0.0 2020年1月21日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class BankAccount {

    private static final Logger LOGGER = getLogger(BankAccount.class);

    @AggregateIdentifier
    private AccountId accountId;
    private String accountName;
    private BigDecimal balance;

    public BankAccount() {
    }

    @CommandHandler
    public BankAccount(CreateAccountCommand command){
        LOGGER.debug("Construct a new BankAccount");
        apply(new CreateAccountEvent(command.getAccountId(), 
        		command.getAccountName(), 
        		command.getAmount()));
    }

    @CommandHandler
    public void handle(WithdrawMoneyCommand command){
        apply(new WithdrawMoneyEvent(command.getAccountId(), 
        		command.getAmount()));
    }

    @EventHandler
    public void on(CreateAccountEvent event){
        this.accountId = event.getAccountId();
        this.accountName = event.getAccountName();
        this.balance = new BigDecimal(event.getAmount());
        LOGGER.info("Account {} is created with balance {}", 
        		accountId, 
        		this.balance);
    }

    @EventHandler
    public void on(WithdrawMoneyEvent event){
        BigDecimal result = this.balance.subtract(
        		new BigDecimal(event.getAmount()));
        if(result.compareTo(BigDecimal.ZERO)<0)
            LOGGER.error("Cannot withdraw more money than the balance!");
        else {
            this.balance = result;
            LOGGER.info("Withdraw {} from account {}, balance result: {}", 
            		event.getAmount(), accountId, balance);
        }
    }
}
