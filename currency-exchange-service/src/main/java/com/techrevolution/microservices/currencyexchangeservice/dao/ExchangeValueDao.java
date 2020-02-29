package com.techrevolution.microservices.currencyexchangeservice.dao;

import com.techrevolution.microservices.currencyexchangeservice.model.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueDao extends JpaRepository<ExchangeValue , Long> {

    ExchangeValue findByFromAndTo(String x, String y);

}
