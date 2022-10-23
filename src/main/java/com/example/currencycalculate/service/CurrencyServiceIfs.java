package com.example.currencycalculate.service;

public interface CurrencyServiceIfs {
    double currency(String country);
    String currencyCalculator(double currency, int usd);
}
