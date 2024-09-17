package org.hj.timebean.tsid;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TSID {
//TSID 어노테이션이 사용된 필드에 대해 실제 동작을 정의하는 코드는
// @EntityListener와 같은 리스너 클래스를 통해 구현
// 이 리스너 클래스가 어노테이션이 붙은 필드에 대해 특정 동작을 수행하도록 정의됩니다.
    //-- TSIDListener 을 통해 구현 -- @EntityListener-> TSIDListener.class 지정
}
