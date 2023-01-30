package com.luxoft.training.spring.cloud;

import java.math.BigDecimal;

public class FundEvent extends AbstractFinancialEvent {
    public FundEvent() {
        super();
    }

    public FundEvent(String originService, String destinationService, BigDecimal sum) {
        super(originService, destinationService, sum);
    }
}
