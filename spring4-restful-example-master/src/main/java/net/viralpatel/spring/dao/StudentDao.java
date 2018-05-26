package net.viralpatel.spring.dao;

import net.viralpatel.spring.model.Student;

import java.util.List;

public interface StudentDao {
    /**
     * This is the method to be used to initialize
     * database resources ie. connection.
     */
    public void create(String name, Integer age);
    public Student getStudent(Integer id);
    public List<Student> listStudents();
    public void delete(Integer id);
    public void update(Integer id, Integer age);
}
