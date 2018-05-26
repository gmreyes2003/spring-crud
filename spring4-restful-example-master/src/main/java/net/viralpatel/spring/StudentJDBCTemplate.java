package net.viralpatel.spring;

import net.viralpatel.spring.dao.StudentDao;
import net.viralpatel.spring.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
@Qualifier("studentDao")
public class StudentJDBCTemplate implements StudentDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void create(String name, Integer age) {
        jdbcTemplate.update("INSERT INTO student (id, name, age) VALUES (?, ?, ?)", 12312,name,age);
        System.out.println("Person Added!!");
    }

    public Student getStudent(Integer id) {
        return null;
    }

    public List<Student> listStudents() {
        return null;
    }

    public void delete(Integer id) {

    }

    public void update(Integer id, Integer age) {

    }
}