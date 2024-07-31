package com.example.anything.pattern.dao;

import com.example.anything.dto.DummyEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Slf4j
public class DummyRepository {

    public void insert(DummyEntity entity) {
        log.info("DummyRepository.insert {}", entity.toString());
    }
}
