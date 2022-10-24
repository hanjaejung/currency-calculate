package com.example.currencycalculate.service;

import com.example.currencycalculate.information.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class CurrencyService implements CurrencyServiceIfs{

    @Autowired
    private Information information;
    //환율정보와 환율계산을 위한 서비스 클래스
    @Override
    public double currency(String country) {
        var currency = information.searchApi(country);
        var usd = currency.getQuotes();

        double num = Double.parseDouble(usd.get("USD" + country));
        //map에 key,value로 저장된 값 gst메소드로 불러오기
        return num;
    }

    @Override
    public String currencyCalculator(double currency, int usd) {
        double result = currency * usd;
        DecimalFormat formatter = new DecimalFormat("###,###.00");
        //DecimalFormat을 이용한 콤마표시와 소수점 2자리까지 반올림을 하였습니다.
        return formatter.format(result);
    }
}
