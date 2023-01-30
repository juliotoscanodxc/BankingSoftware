package com.luxoft.training.spring.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardRest {
    @Autowired
    private CardNumberGenerator generator;

    private static Logger log = LoggerFactory.getLogger(CardRest.class);

    @RequestMapping("create")
    @PreAuthorize("hasAuthority('CARD_WRITE')")
    public String createNewCard() {
        log.info("generating a card number");
        return generator.generate();
    }
}
