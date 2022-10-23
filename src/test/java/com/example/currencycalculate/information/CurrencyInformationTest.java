package com.example.currencycalculate.information;

import com.example.currencycalculate.service.CurrencyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CurrencyInformationTest {

    @Autowired
    private Information information;

    @Autowired
    private CurrencyService currencyService;

    @Test
    public void currencyInformationTest() throws JsonProcessingException, JSONException {

        var result = information.searchApi("KRW");  //KRW 값 확인 테스트
        var getQuotes = result.getQuotes();
        System.out.println(getQuotes); //api 열결 후 환율객체 값 확인 테스트

        System.out.println(getQuotes.get("USD" + "KRW")); //KRW 값 확인 테스트

        var currency = getQuotes.get("USD" + "KRW");
        var usd = 10; // 입력값 테스트
        var caculateResult = currencyService.currencyCalculator(Double.parseDouble(currency), usd);

        System.out.println(caculateResult); //계산값 확인 테스트

    }
}
