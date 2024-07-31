package com.example.anything.pattern;

import com.example.anything.dto.DumDummyEntity;
import com.example.anything.dto.DummyEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class PatternServiceTest {

    @Autowired
    PatternService patternService;

    @Test
    public void 테스트호자() {

        List<DummyEntity> dummyEntityList = new ArrayList<>();
        dummyEntityList.add(DummyEntity.builder().id("A").build());
        dummyEntityList.add(DummyEntity.builder().id("B").build());
        dummyEntityList.add(DummyEntity.builder().id("B").build());
        dummyEntityList.add(DummyEntity.builder().id("B").build());

        Set<String> codes = new HashSet<>();
        codes.add("A");
        codes.add("B");

        List<DumDummyEntity> dumDummyEntityList = new ArrayList<>();
        dumDummyEntityList.add(DumDummyEntity.builder().degree(1).build());
        dumDummyEntityList.add(DumDummyEntity.builder().degree(1).build());
        dumDummyEntityList.add(DumDummyEntity.builder().degree(2).build());
        dumDummyEntityList.add(DumDummyEntity.builder().degree(3).build());

        Set<Integer> degrees = new HashSet<>();
        degrees.add(1);
        degrees.add(2);
        degrees.add(3);

        patternService.patternInsert(dummyEntityList,codes,dumDummyEntityList,degrees);
    }
}