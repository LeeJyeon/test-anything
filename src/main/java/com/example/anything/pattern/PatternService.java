package com.example.anything.pattern;

import com.example.anything.dto.DumDummyEntity;
import com.example.anything.dto.DummyEntity;
import com.example.anything.pattern.dao.DumDummyRepository;
import com.example.anything.pattern.dao.DummyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatternService {

    private final DummyRepository dummyRepository;
    private final DumDummyRepository dumDummyRepository;

    public void patternInsert(List<DummyEntity> dummyEntityList, Set<String> codes, List<DumDummyEntity> dumDummyEntityList, Set<Integer> degrees) {

        List<Integer> sms = new ArrayList<>();

        InsertTemplate<DummyEntity, String> insertTemplate = new InsertTemplate<>();

        List<DummyEntity> insertedDummy = insertTemplate.insertAndVerifyEnoughCode(dummyEntityList, codes, (DummyEntity dummy) -> {
            dummyRepository.insert(dummy);
            return dummy.getId();
        });

        InsertTemplate<DumDummyEntity, Integer> insertTemplate2 = new InsertTemplate<>();

        List<DumDummyEntity> insertedDumDummy = insertTemplate2.insertAndVerifyEnoughCode(dumDummyEntityList, degrees, (DumDummyEntity dumDummy) -> {
            dumDummyRepository.insert(dumDummy);
            sms.add(dumDummy.getDegree());
            return dumDummy.getDegree();
        });
    }
}


/*
*   InsertTemplate<DummyEntity, String> insertTemplate = new InsertTemplate<>();

        List<DummyEntity> insertedDummy = insertTemplate.insertAndVerifyEnoughCode(
                dummyEntityList
                , codes
                , (DummyEntity dummy) -> {
                    dummyRepository.insert(dummy);
                    return dummy.getId();
                });

        InsertTemplate<DumDummyEntity, Integer> insertTemplate2 = new InsertTemplate<>();

        List<DumDummyEntity> insertedDumDummy = insertTemplate2.insertAndVerifyEnoughCode(dumDummyEntityList
                , degrees
            ,(DumDummyEntity dumDummy) -> {
                    dumDummyRepository.insert(dumDummy);
                    sms.add(dumDummy.getDegree());
                    return dumDummy.getDegree();
                });
*
* */

/*
*
*  InsertTemplate<DummyEntity, String> dummyInsertTemplate = new InsertTemplate<>((DummyEntity dummy) -> {
            dummyRepository.insert(dummy);
            return dummy.getId();
        });

        InsertTemplate<DumDummyEntity, Integer> dumDummyInsertTemplate = new InsertTemplate<>((DumDummyEntity dumDummy) -> {
            dumDummyRepository.insert(dumDummy);
            sms.add(dumDummy.getDegree());
            return dumDummy.getDegree();
        });

        List<DummyEntity> insertedDummy = dummyInsertTemplate.insertAndVerifyEnoughCode(dummyEntityList, codes);
        List<DumDummyEntity> insertedDumDummy = dumDummyInsertTemplate.insertAndVerifyEnoughCode(dumDummyEntityList, degrees);

        sms.forEach(System.out::println);
    }
    * */