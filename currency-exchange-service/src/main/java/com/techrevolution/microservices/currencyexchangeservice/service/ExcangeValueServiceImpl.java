package com.techrevolution.microservices.currencyexchangeservice.service;

import com.techrevolution.microservices.currencyexchangeservice.dao.ExchangeValueDao;
import com.techrevolution.microservices.currencyexchangeservice.model.ExchangeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExcangeValueServiceImpl implements ExchangeValueService{

    private final ExchangeValueDao exchangeValueDao;

    @Autowired
    public ExcangeValueServiceImpl(ExchangeValueDao exchangeValueDao) {
        this.exchangeValueDao = exchangeValueDao;
    }

    @Override
    public ExchangeValue findByFromAndTo(String from, String to) {
        return exchangeValueDao.findByFromAndTo(from , to);
    }
}
