package com.waylau.axon.cqrs;


import static org.slf4j.LoggerFactory.getLogger;

import org.axonframework.config.Configuration;
import org.axonframework.config.DefaultConfigurer;
import org.axonframework.eventsourcing.eventstore.inmemory.InMemoryEventStorageEngine;
import org.slf4j.Logger;

import com.waylau.axon.cqrs.command.aggregates.BankAccount;
import com.waylau.axon.cqrs.command.commands.CreateAccountCommand;
import com.waylau.axon.cqrs.command.commands.WithdrawMoneyCommand;
import com.waylau.axon.cqrs.common.domain.AccountId;

/**
 * 主应用入口.	
 * 
 * @since 1.0.0 2020年1月21日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class Application {
    private static final Logger LOGGER = getLogger(Application.class);
    
    public static void main(String args[]) throws InterruptedException{
    	LOGGER.info("Application is start.");
    	Configuration config = DefaultConfigurer.defaultConfiguration()
                .configureAggregate(BankAccount.class)
                .configureEmbeddedEventStore(c -> 
                	new InMemoryEventStorageEngine())
                .buildConfiguration();
        config.start();
        AccountId id = new AccountId();
        config.commandGateway().send(new CreateAccountCommand(id, 
        		"MyAccount",1000));
        config.commandGateway().send(new WithdrawMoneyCommand(id, 500));
        config.commandGateway().send(new WithdrawMoneyCommand(id, 500));
        config.commandGateway().send(new WithdrawMoneyCommand(id, 500));
        
        // 线程先睡五秒，等事件处理完
        Thread.sleep(5000L);
        
    	LOGGER.info("Application is shutdown.");
    }

}
