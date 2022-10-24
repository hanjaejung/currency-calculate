package com.example.currencycalculate.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationKeyRes {
    //환율정보 가져오는 객체
    private boolean success;
    private String terms;
    private String privacy;
    private int timestamp;
    private String source;
    private Map<String, String> quotes;


}
