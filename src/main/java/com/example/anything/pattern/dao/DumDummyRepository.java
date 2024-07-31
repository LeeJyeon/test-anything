package com.example.anything.pattern.dao;

import com.example.anything.dto.DumDummyEntity;
import com.example.anything.dto.DummyEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Slf4j
public class DumDummyRepository {

    public void insert(DumDummyEntity entity) {
        entity.setId(UUID.randomUUID().toString());
        entity.setName("name");
        log.info("DumDummyRepository.insert {}", entity.toString());
    }
}
