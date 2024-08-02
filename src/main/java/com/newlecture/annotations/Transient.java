package com.newlecture.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // annotation은 컴파일러가 폐기함 > 런타임까지 이어줌
@Target({ElementType.FIELD, ElementType.METHOD}) // 적용 범위 설정
public @interface Transient {

}
