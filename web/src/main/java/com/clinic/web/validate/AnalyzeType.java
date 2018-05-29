package com.clinic.web.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Constraint(validatedBy = AnalyzeTypeConstraintValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface AnalyzeType {
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String message() default "Несуществующий анализ";
}
