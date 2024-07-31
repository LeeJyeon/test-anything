package com.example.anything.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DumDummyEntity {
    private String id;
    private String name;
    private Integer degree;
}
