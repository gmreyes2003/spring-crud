package net.viralpatel.spring.controller;

import net.viralpatel.spring.dao.StudentDao;
import net.viralpatel.spring.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRestController {

    @Autowired
	private StudentDao studentDao;

	@PostMapping("/students")
	public ResponseEntity getStudent(@RequestBody Student student) {

		studentDao.create(student.getName(),student.getAge());
		return new ResponseEntity(student, HttpStatus.OK);
	}

}