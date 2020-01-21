package com.waylau.axon.cqrs.common.domain;

import org.axonframework.common.Assert;
import org.axonframework.common.IdentifierFactory;

import java.io.Serializable;

/**
 * Account Id.
 * 
 * @since 1.0.0 2020年1月21日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class AccountId implements Serializable {

    private static final long serialVersionUID = 7119961474083133148L;
    private final String identifier;

    private final int hashCode;

    public AccountId() {
        this.identifier = 
        		IdentifierFactory.getInstance().generateIdentifier();
        this.hashCode = identifier.hashCode();
    }

    public AccountId(String identifier) {
        Assert.notNull(identifier, ()->"Identifier may not be null");
        this.identifier = identifier;
        this.hashCode = identifier.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountId accountId = (AccountId) o;

        return identifier.equals(accountId.identifier);

    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    @Override
    public String toString() {
        return identifier;
    }

}
