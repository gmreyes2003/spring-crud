package net.viralpatel.spring;

import net.viralpatel.spring.dao.StudentDao;
import net.viralpatel.spring.model.Student;
import net.viralpatel.spring.model.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("studentDao")
public class StudentJDBCTemplate implements StudentDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void create(String name, Integer age) {
        jdbcTemplate.update("INSERT INTO student (id, name, age) VALUES (?, ?, ?)", 12312, name, age);
        System.out.println("Student Added!!");
    }

    public Student getStudent(Long id) {
        String SQL = "select * from Student where id = ?";
        Student student = jdbcTemplate.queryForObject(SQL, new Object[]{id}, new StudentMapper());
        System.out.println("Student " + student.toString() );
        return student;
    }

    public List<Student> listStudents() {
        String SQL = "select * from Student";
        List <Student> students = jdbcTemplate.query(SQL, new StudentMapper());
        System.out.println("list students " + students.toString() );
        return students;
    }

    public void delete(Long id) {
        String SQL = "delete from Student where id = ?";
        jdbcTemplate.update(SQL, id);
        System.out.println("Deleted Record with ID = " + id );
        return;
    }

    public void update(Long id, Student student) {
        String SQL = "update Student set age = ? where id = ?";
        jdbcTemplate.update(SQL, student.getAge(), id);
        System.out.println("Updated Record with ID = " + id );
        return;
    }
}