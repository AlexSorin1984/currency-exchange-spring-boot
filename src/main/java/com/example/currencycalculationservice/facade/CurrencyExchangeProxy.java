package com.example.currencycalculationservice.facade;

import com.example.currencycalculationservice.model.CalculatedAmount;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name ="currency-exchange-service", url="http://localhost:8000/")
public interface CurrencyExchangeProxy {
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CalculatedAmount retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
