package com.example.currencycalculate.service;

import com.example.currencycalculate.information.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class CurrencyService implements CurrencyServiceIfs{

    @Autowired
    private Information information;

    @Override
    public double currency(String country) {
        var currency = information.searchApi(country);
        var usd = currency.getQuotes();

        double num = Double.parseDouble(usd.get("USD" + country));
        return num;
    }

    @Override
    public String currencyCalculator(double currency, int usd) {
        double result = currency * usd;
        DecimalFormat formatter = new DecimalFormat("###,###.00");
        return formatter.format(result);
    }
}
