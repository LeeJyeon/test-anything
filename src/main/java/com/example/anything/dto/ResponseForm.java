package com.example.anything.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.ToString;

@ToString
public class ResponseForm<T> {

    @JsonAlias("header")
    public ResponseHeader responseHeader;
    @JsonAlias("data")
    public ResponseData<T> responseData;

}
