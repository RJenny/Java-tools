package com.storm.reflect;

import java.lang.reflect.*;

/**
 * 对象反射
 */
public class Reflect {

    public static Class getClassName(String packageName) throws ClassNotFoundException {
       Class aClass = Class.forName(packageName);
       return aClass;
    }

    public static void buildArray(){
        int[] test = (int[]) Array.newInstance(int.class, 10);
        for (int i = 0; i < test.length; i++){
            Array.set(test, i, i+1);
        }
        for (int i = 0 ; i< test.length ; i++){
            System.out.println(Array.get(test, i));
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class c = getClassName("com.storm.reflect.Fruit" ) ;
        System.out.println(c.getName());
        System.out.println(c.getSimpleName());
        System.out.println(c.getModifiers());
        System.out.println(c.getInterfaces().length);
        Constructor[] constructors = c.getConstructors();
        for (Constructor constructor:constructors){
            System.out.println(constructor.toString());
        }
        Field[] fields = c.getFields();
        for (Field field:fields){
            System.out.println(field.getName());
        }
//        Method method = c.getMethod("setName");
 //       method.invoke(c, "苹果");
        buildArray();
    }
}
