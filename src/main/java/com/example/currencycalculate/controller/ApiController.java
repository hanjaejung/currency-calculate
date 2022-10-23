package com.example.currencycalculate.controller;

import com.example.currencycalculate.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/currency")
@RequiredArgsConstructor
public class ApiController {

    private final CurrencyService currencyService;

    @GetMapping("/country")
    public double countryCurrency(@RequestParam String country){
        return currencyService.currency(country);
    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam double currency, @RequestParam int usd){
        return currencyService.currencyCalculator(currency, usd);
    }

}
