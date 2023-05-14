package etu2091.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)

    public @interface AnnotationMethod{
            String value() default "Method";
    }

