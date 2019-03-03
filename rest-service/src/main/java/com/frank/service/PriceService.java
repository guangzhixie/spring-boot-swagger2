package com.frank.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PriceService {

    public Double query(BigDecimal amount) {
        return amount.compareTo(BigDecimal.TEN) > 0 ? 5.50 : 6.50;
    }
}
