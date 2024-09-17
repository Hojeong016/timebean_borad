package org.hj.timebean.tsid;

import jakarta.persistence.PrePersist;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Slf4j
public class TSIDListener {

    //jpa 생명주기 관리 :  @PrePersist : 엔티티가 데이터베이스에 처음 저장되기 전에 호출되는 메서드를 지정하는 데 사용
    @PrePersist
    public void prePersist(Object entity) {

        try {
            Field[] fields = entity.getClass().getDeclaredFields(); //getDeclaredFields()는 특정 클래스의 모든 필드를 반환합니다
            for(Field field : fields){
                if(field.isAnnotationPresent(TSID.class) && field.getType().equals(String.class)){
                    field.setAccessible(true);//필드 접근을 허용

                    String tstd = createTSID();
                    field.set(entity, tstd);
                }
            }
        } catch (IllegalAccessException e) {
            log.info("필드 주입 실패");
            throw new RuntimeException(e);
        }
    }

    private String createTSID() {
        return Instant.now().toEpochMilli() + UUID.randomUUID().toString();
    }
}
