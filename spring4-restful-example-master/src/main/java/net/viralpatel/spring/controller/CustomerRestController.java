package net.viralpatel.spring.controller;

import net.viralpatel.spring.dao.StudentDao;
import net.viralpatel.spring.exception.StudentNotFoundException;
import net.viralpatel.spring.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerRestController {

    @Autowired
    private StudentDao studentDao;

    @RequestMapping("/")
    public String welcome() {//Welcome page, non-rest
        return "Welcome to RestTemplate Example.";
    }

    @PostMapping(path = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity setStudent(@RequestBody Student student) {
        studentDao.create(student.getName(), student.getAge());
        return new ResponseEntity(student, HttpStatus.OK);
    }

    @GetMapping(path = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getStudents() {
        return studentDao.listStudents();
    }

    @GetMapping(path = "/student/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getCustomer(@PathVariable("id") Long id) {
        Student student = studentDao.getStudent(id);
        try {
            if (student == null) {
                throw new StudentNotFoundException("Student not found with id " + id);
            }
        } catch (StudentNotFoundException e) {
            e.printStackTrace();
        }

        return new ResponseEntity(student, HttpStatus.OK);
    }

    @DeleteMapping(path = "/student/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteCustomer(@PathVariable Long id) {
        studentDao.delete(id);
    }

    @PutMapping(path = "/student/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateCustomer(@PathVariable Long id, @RequestBody Student student) {
        studentDao.update(id, student);
    }


}