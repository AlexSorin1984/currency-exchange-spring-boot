package com.example.currencycalculationservice.controller;

import com.example.currencycalculationservice.facade.CurrencyExchangeProxy;
import com.example.currencycalculationservice.model.CalculatedAmount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.management.InvalidAttributeValueException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyCalculationController {
    @Autowired
    private CurrencyExchangeProxy currencyExchangeProxy;

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CalculatedAmount calculateAmount(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);
        ResponseEntity<CalculatedAmount> responseEntity = new RestTemplate().
                getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CalculatedAmount.class, uriVariables);

        BigDecimal totalAmount = responseEntity.getBody().getConversionMultiple().multiply(quantity);

        CalculatedAmount calculatedAmount = new CalculatedAmount(
                4L, from, to, responseEntity.getBody().getConversionMultiple(), quantity, totalAmount,5000);

        //return new CalculatedAmount(100L, from, to, BigDecimal.ONE, quantity, BigDecimal.valueOf(12000), 8100);
        return calculatedAmount;
    }

    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CalculatedAmount calculateAmountFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){

        CalculatedAmount calculatedAmount = currencyExchangeProxy.retrieveExchangeValue(from, to);

        BigDecimal totalAmount = calculatedAmount.getConversionMultiple().multiply(quantity);

        return new CalculatedAmount(
                calculatedAmount.getId(), from, to, calculatedAmount.getConversionMultiple(), quantity, totalAmount,5000);
    }
}
