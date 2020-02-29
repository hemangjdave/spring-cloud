package com.techrevolution.microservices.currencyexchangeservice.service;

import com.techrevolution.microservices.currencyexchangeservice.model.ExchangeValue;

public interface ExchangeValueService {

    ExchangeValue findByFromAndTo(String from, String to);


}
