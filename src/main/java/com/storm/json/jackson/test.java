package com.storm.json.jackson;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class test {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        /*objectMapper.findAndRegisterModules();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        System.out.println(objectMapper.writeValueAsString(Instant.now()));*/
        writeValueString();
    }

    public static void  writeValueString() throws JsonProcessingException {
        //Person person = new Person();
        //person.setAge(25);
        //person.setSex("");
        //System.out.println(objectMapper.writeValueAsString(person));
        String s = "[{\n" +
                "\t\t\"name\": \"yq\",\n" +
                "\t\t\"age\": 25,\n" +
                "\t\t\"sex\": \"f\"\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"name\": \"yq1\",\n" +
                "\t\t\"age\": 26,\n" +
                "\t\t\"sex\": \"m\"\n" +
                "\t}\n" +
                "]";
        s = s.replaceAll("\t","").replaceAll("\n","");
        List<Person> personList = JsonMapperUtil.toList(s, Person.class);
        System.out.println(personList);
    }

    public static void  readValue() throws IOException {
        Person person = objectMapper.readValue("{\"age\":12, \"sex\":\"f\"}", Person.class);
        System.out.println(person.getAge());
        System.out.println(person.getSex());
        System.out.println(person.getName());
    }

    public static void  readValue1() throws IOException {
        objectMapper.setVisibility(PropertyAccessor.ALL,JsonAutoDetect.Visibility.NONE).setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        Person person = new Person("yq", 25, "f");
        System.out.println(objectMapper.writeValueAsString(person));
    }
}
