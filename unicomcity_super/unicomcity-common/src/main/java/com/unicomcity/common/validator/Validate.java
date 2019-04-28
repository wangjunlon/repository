package com.unicomcity.common.validator;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER,ElementType.METHOD})
public @interface Validate
{
	Class valiclass() default String.class;
	Class<?>[] groups() default { };
}