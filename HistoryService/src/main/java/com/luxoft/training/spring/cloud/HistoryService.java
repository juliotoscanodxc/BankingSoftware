package com.luxoft.training.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@SpringBootApplication
@RemoteApplicationEventScan
@RestController
public class HistoryService {
    private Map<Date, BigDecimal> historyMap = Collections.synchronizedMap(new LinkedHashMap<Date, BigDecimal>());

    @GetMapping
    public Map<Date, BigDecimal> getHistory() {
        return historyMap;
    }

    @EventListener
    public void onEvent(AbstractFinancialEvent event) {
        historyMap.put(new Date(event.getTimestamp()), event.getSum());
    }

    public static void main(String[] args) {
        SpringApplication.run(HistoryService.class, args);
    }
}
