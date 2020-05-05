package com.storm.json.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
//方法一
//@NoArgsConstructor
public class Person implements Serializable {

    private String name;

    private Integer age;

    private String sex;

    //方法二
    @JsonCreator
    public Person( @JsonProperty("name") String name,  @JsonProperty("age") Integer age,  @JsonProperty("sex") String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}
