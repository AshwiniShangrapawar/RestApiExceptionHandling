package com.ash.restapi.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ash.restapi.entity.Student;
import com.ash.restapi.exception.StudentNotFoundException;
import com.ash.restapi.service.StudentService;

@RestController
@RequestMapping("/v1/api/student")
public class StudentRestController {

	@Autowired
	private StudentService service;
	
	// 1 : create new Student
		@PostMapping("/create")
		public ResponseEntity<String> createStudent(@RequestBody Student s) {
			Integer id = service.saveStudent(s);
			String msg = "Student " + id + " CREATED";
			ResponseEntity<String> response = new ResponseEntity<String>(msg, HttpStatus.CREATED);
			return response;
//			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}

		// 2. Fetch one by id
		@GetMapping("/find/{id}")
		public ResponseEntity<Student> getOneStudent(@PathVariable("id") Integer id) {   

			ResponseEntity<Student> response = null;

			try {
				Student stud = service.getOneStudent(id);
				response = ResponseEntity.ok(stud);
			} catch (StudentNotFoundException snf) {
				snf.printStackTrace();
			throw snf;
			}
			return response;
		}

		// 3. fetch all student
		@GetMapping("/all")
		public ResponseEntity<List<Student>> getAllStudent() {
			List<Student> allStudents = service.getAllStudents();
			return ResponseEntity.ok(allStudents);
//			return new ResponseEntity<List<Student>>(allStudents, HttpStatus.OK);
		}

	//4. delete one student by id
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<String> deleteStudent(@PathVariable("id") Integer id) {

			ResponseEntity<String> resonse = null;
			try {
				service.deleteStudent(id);
				resonse = ResponseEntity.ok("STUDENT " + id + " REMOVED");
			} catch (StudentNotFoundException e) {
				e.printStackTrace();
				throw e;
			}
			return resonse;
		} 

		// 5. UPDATE Student
		@PutMapping("/modify")
		public ResponseEntity<String> updateStudent(@RequestBody Student s) {

			ResponseEntity<String> resonse = null;
			try {
				service.UpdateStudent(s);
				resonse = ResponseEntity.ok("STUDENT ' " + s.getStdID() + " ' UPDATED");
			} catch (StudentNotFoundException e) {
				e.printStackTrace();
				throw e;
			}
			return resonse;
		}

	
}
