package com.techrevolution.microservices.currencyconversionservice.controller;

import com.techrevolution.microservices.currencyconversionservice.model.CurrencyConversionBean;
import com.techrevolution.microservices.currencyconversionservice.controller.proxy.CurrencyExchangeServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    private final CurrencyExchangeServiceProxy currencyExchangeServiceProxy;

    @Autowired
    public CurrencyConversionController(CurrencyExchangeServiceProxy currencyExchangeServiceProxy) {
        this.currencyExchangeServiceProxy = currencyExchangeServiceProxy;
    }

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable("from")String from , @PathVariable String to , @PathVariable  BigDecimal quantity){
        Map<String, String> urlVariables = new HashMap<>();
        urlVariables.put("from", from);
        urlVariables.put("to", to);
        ResponseEntity<CurrencyConversionBean> currencyConversionBeanResponseEntity =
                new RestTemplate().
                        getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                                CurrencyConversionBean.class,
                                urlVariables);

        CurrencyConversionBean currencyConversionBean = currencyConversionBeanResponseEntity.getBody();


        return new CurrencyConversionBean(currencyConversionBean.getId(), from, to,
                currencyConversionBean.getConversionMultiple(),
                quantity, quantity.multiply(currencyConversionBean.getConversionMultiple()), currencyConversionBean.getPort());
    }

    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrencyFeign(@PathVariable("from")String from , @PathVariable String to , @PathVariable  BigDecimal quantity){


        CurrencyConversionBean currencyConversionBean = currencyExchangeServiceProxy.getCurrencyDetails(from, to);


        return new CurrencyConversionBean(currencyConversionBean.getId(), from, to,
                currencyConversionBean.getConversionMultiple(),
                quantity, quantity.multiply(currencyConversionBean.getConversionMultiple()), currencyConversionBean.getPort());
    }

}
