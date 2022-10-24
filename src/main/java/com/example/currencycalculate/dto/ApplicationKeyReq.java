package com.example.currencycalculate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationKeyReq {
    //국가 코드 입력받는 겍체
    private String country;
}
