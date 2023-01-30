package com.luxoft.training.spring.cloud;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class AccountEntity implements Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer clientId;
    private BigDecimal balance;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public Integer getClientId() {
        return clientId;
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
