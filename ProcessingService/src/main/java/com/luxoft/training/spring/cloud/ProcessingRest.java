package com.luxoft.training.spring.cloud;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProcessingRest {
    @Autowired
    private ProcessingRepository repo;

    private static Logger log = LoggerFactory.getLogger(ProcessingRest.class);

    @Autowired
    private AccountServiceClient accountServiceClient;

    @Autowired
    private CardServiceClient cardServiceClient;

    @RequestMapping("/issue/{accountId}")
    public String issueNewCard(@PathVariable Integer accountId) {
        log.info("issuing a card");
        final String card = cardServiceClient.createCard();
        if (card == null) return "CARD_SERVICE_NOT_AVAILABLE";
        log.info("card is issued with number "+card);
        ProcessingEntity pe = new ProcessingEntity();
        pe.setCard(card);
        pe.setAccountId(accountId);
        repo.save(pe);
        return card;
    }

    @RequestMapping("/checkout/{card}")
    public boolean checkout(@PathVariable String card, @RequestParam BigDecimal sum) {
        ProcessingEntity pe = repo.findByCard(card);
        if (pe == null) {
            return false;
        }
        return accountServiceClient.checkout(pe.getAccountId(), sum);
    }

    @RequestMapping("/get")
    public Map<Integer, String> getByAccount(@RequestParam("account_id") List<Integer> accountIdList) {
        List<ProcessingEntity> list = repo.findByAccountIdIn(accountIdList);
        Map<Integer, String> map = new HashMap<Integer, String>();
        for (ProcessingEntity pe: list) {
            map.put(pe.getAccountId(), pe.getCard());
        }
        return map;
    }

    @HystrixCommand(fallbackMethod = "testFallback")
    @RequestMapping("/test")
    public String testHystrix(Boolean fail) {
        if (Boolean.TRUE.equals(fail)) {
            throw new RuntimeException();
        }
        return "OK";
    }

    private String testFallback(Boolean fail) {
        return "FAILED";
    }

}

