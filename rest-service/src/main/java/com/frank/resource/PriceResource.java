package com.frank.resource;

import com.frank.service.PriceService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class PriceResource {
    private static final String PRICE_URI = "/price";

    @Autowired
    private PriceService priceService;

    @ApiOperation(value = "Query price for a certain amount")
    @RequestMapping(value = PRICE_URI+"/query", method = GET)
    public Double viewOrder(@RequestParam(value="amount") String amount) {
        return priceService.query(new BigDecimal(amount));
    }
}
