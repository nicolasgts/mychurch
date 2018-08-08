package com.nicolas.gts.mychurch.services.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = ChurchInsertValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ChurchInsert {
	String message() default "Validation Error";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
