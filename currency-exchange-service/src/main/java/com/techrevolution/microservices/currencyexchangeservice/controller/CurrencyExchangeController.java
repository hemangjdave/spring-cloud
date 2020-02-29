package com.techrevolution.microservices.currencyexchangeservice.controller;

import com.techrevolution.microservices.currencyexchangeservice.model.ExchangeValue;
import com.techrevolution.microservices.currencyexchangeservice.service.ExchangeValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    private final Environment environment;
    private final ExchangeValueService exchangeValueService;

    @Autowired
    public CurrencyExchangeController(Environment environment, ExchangeValueService exchangeValueService) {
        this.environment = environment;
        this.exchangeValueService = exchangeValueService;
    }

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue getExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to) {
        ExchangeValue exchangeValue = exchangeValueService.findByFromAndTo(from, to);
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return exchangeValue;
    }
}
