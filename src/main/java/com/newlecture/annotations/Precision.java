package com.newlecture.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
public @interface Precision { // 소수점 설정
	public int value() default 2; // 기본속성
	public int val() default 2; // 내가 만든 속성

}
