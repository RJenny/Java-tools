package com.storm.reflect;

@MyAnnotation(name = "test", value = "test")
public class AnnotationObject {

    @MyAnnotation(name = "field", value = "field")
    private String field;

    @MyAnnotation(name = "method", value = "method")
    public void doSomething(){
        System.out.println("Do Something");
    }
}
