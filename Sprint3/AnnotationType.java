package etu2091.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)

public @interface AnnotationType{
	String value() default "Class";
}


