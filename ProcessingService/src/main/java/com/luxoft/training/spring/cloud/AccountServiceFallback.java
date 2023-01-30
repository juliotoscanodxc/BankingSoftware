package com.luxoft.training.spring.cloud;


import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class AccountServiceFallback implements AccountServiceClient {

    @Override
    public boolean checkout(Integer accountId, BigDecimal sum) {
        return false;
    }
}
