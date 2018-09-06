package org.axp.springbootcouchbase.mvc.model;

@Document
public class Student {

    @Id
    private String id;

    @Field
    private String name;

    @Field
    private Integer age;

    // can add more data types from more test scenarios

    public Student(String id, String name, Integer age) {

        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() { return id; }

    public String getName() { return name; }

    public Integer getAge() { return age; }

}
