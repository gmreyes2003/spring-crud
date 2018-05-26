package net.viralpatel.spring.controller;

import net.viralpatel.spring.dao.StudentDao;
import net.viralpatel.spring.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/student")
    public ResponseEntity setStudent(@RequestBody Student student) {
        studentDao.create(student.getName(), student.getAge());
        return new ResponseEntity(student, HttpStatus.OK);
    }

    @GetMapping("/student")
    public List<Student> getStudents() {
        return studentDao.listStudents();
    }

    @GetMapping("/student/{id}")
    public ResponseEntity getCustomer(@PathVariable("id") Long id) {

        Student student = studentDao.getStudent(id);
        if (student == null) {
            return new ResponseEntity("No student found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(student, HttpStatus.OK);
    }

    @DeleteMapping("/student/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        studentDao.delete(id);
    }

    @PutMapping("/student/{id}")
    public void updateCustomer(@PathVariable Long id, @RequestBody Student student) {
        studentDao.update(id, student);
    }


}