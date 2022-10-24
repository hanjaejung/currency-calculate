package com.example.currencycalculate.information;

import com.example.currencycalculate.dto.ApplicationKeyReq;
import com.example.currencycalculate.dto.ApplicationKeyRes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class Information {
    //apiKey정보를 @Value어노테이션을 통해 가져옵니다.
    @Value("${currency.api.key}")
    private String apiKey;

    public ApplicationKeyRes searchApi(String country){
        var applecationKeyReq = new ApplicationKeyReq();
        applecationKeyReq.setCountry(country);
        //UriComponentsBuilder를 이용하여 환율정보를 가져옵니다
        var uri = UriComponentsBuilder.fromUriString("http://www.apilayer.net/api/live")
                .queryParam("access_key",apiKey)
                .queryParam("currencies",applecationKeyReq.getCountry())
                .build()
                .encode()
                .toUri();

        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        var httpEEntity = new HttpEntity<>(headers);
        var responseType = new ParameterizedTypeReference<ApplicationKeyRes>(){};

        var responseEntity = new RestTemplate().exchange(
                uri,
                HttpMethod.GET,
                httpEEntity,
                responseType
        );

        return responseEntity.getBody();
    }
}
