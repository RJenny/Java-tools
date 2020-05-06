package com.storm.reflect;

public class Fruit {

    public String name;

    public String area;

    public void setName(String name) {
        this.name = name;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void getName(){
        System.out.println("获取名称...");
    }

    public void locate(){
        System.out.println("得到在那个区域");
    }
}
