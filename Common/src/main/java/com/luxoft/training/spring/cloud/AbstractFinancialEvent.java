package com.luxoft.training.spring.cloud;

import org.springframework.cloud.bus.event.RemoteApplicationEvent;

import java.math.BigDecimal;

public abstract class AbstractFinancialEvent extends RemoteApplicationEvent {
    private static Object source = new Object();
    private BigDecimal sum;

    public AbstractFinancialEvent() {
        super();
    }

    public AbstractFinancialEvent(String originService, String destinationService, BigDecimal sum) {
        super(source, originService, destinationService);
        this.sum = sum;
    }

    public BigDecimal getSum() {
        return sum;
    }
}
