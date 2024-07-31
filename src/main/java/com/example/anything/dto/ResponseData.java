package com.example.anything.dto;

import lombok.ToString;

import java.util.List;

@ToString
public class ResponseData<T> {
    public String resultCode;
    public String resultMsg;
    public List<List<T>> result;
}
