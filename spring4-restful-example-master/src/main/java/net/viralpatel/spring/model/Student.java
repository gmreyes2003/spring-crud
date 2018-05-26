package net.viralpatel.spring.model;

public class Student {
    private Integer age;
    private String name;
    private Integer id;

    public Student(Integer age, String name, Integer id) {
        this.age = age;
        this.name = name;
        this.id = id;
    }

    public Student() {
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
