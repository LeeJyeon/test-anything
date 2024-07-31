package com.example.anything.pattern;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InsertTemplate<Entity, ValidationCode> {

    public List<Entity> insertAndVerifyEnoughCode(List<Entity> sourceList
            , Set<ValidationCode> criteriaSet
            , InsertStrategy<Entity, ValidationCode> insertStrategy) {

        Set<ValidationCode> codeSet =
                sourceList.stream()
                        .map(insertStrategy::insert).collect(Collectors.toSet());

        if (!criteriaSet.equals(codeSet)) {
            throw new IllegalArgumentException("!");
        }

        return sourceList;
    }
}
