package org.hj.timebean.tsid;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.lang.reflect.Field;
import java.time.Instant;
import java.util.*;

import static java.util.UUID.randomUUID;
import static org.junit.jupiter.api.Assertions.*;

//1. 검증할 것
// - 어노테이션 적용 여부
// - 유일성 검증
class TSIDListenerTest {

    private TSIDListener Listener;

    @BeforeEach
    void setUp() {
        Listener = new TSIDListener();
    }

    //엔티티 생성 여부 확인
    @Test
    public void setTestEntity() throws NoSuchFieldException, IllegalAccessException {
        //given
        TestEntity testEntity = new TestEntity();
        //when
        Listener.prePersist(testEntity);
        //then
        assertNotNull(testEntity.getId());
    }

    //중복된 것이 없는가
    @Test
    public void unique() throws NoSuchFieldException, IllegalAccessException {

        //중복허용 안함
        Set<String> uniqueId = new HashSet<>();
        List<String> allId = new ArrayList<>();

        //여러개의 객체 생성
        for(int i = 0; i <=1000000; i++){
            TestEntity testEntity = new TestEntity();

            Listener.prePersist(testEntity);

            Field field = testEntity.getClass().getDeclaredField("id");
            field.setAccessible(true); //private 접근 허용
            String id = (String) field.get(testEntity);

            uniqueId.add(id);
            allId.add(id);
        }

        assertEquals(uniqueId.size(), allId.size());

    }

    //UUID  중복 비교
    @Test
    public void time(){
        //중복허용 안함
        Set<String> uniqueId = new HashSet<>();
        List<String> allId = new ArrayList<>();

        for(int i =0; i<=1000000; i++){
            UUIDTestEntity UUID = new UUIDTestEntity(randomUUID());
            String id = UUID.getId().toString();

            uniqueId.add(id);
            allId.add(id);
        }
        //then
        assertEquals(uniqueId.size(), allId.size());
    }


    public static class TestEntity{

        @TSID
        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static class UUIDTestEntity{

        private UUID id;

        public UUIDTestEntity(UUID id) {
            this.id = randomUUID();
        }

        public UUID getId() {
            return id;
        }

    }
}



