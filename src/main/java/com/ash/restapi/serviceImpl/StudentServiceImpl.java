package com.ash.restapi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ash.restapi.entity.Student;
import com.ash.restapi.exception.StudentNotFoundException;
import com.ash.restapi.repository.StudentRepository;
import com.ash.restapi.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository repo;
	@Override
	public Integer saveStudent(Student s) {
		s = repo.save(s);
		return s.getStdID();
	}

	@Override
	public void UpdateStudent(Student s) {
		if (s.getStdID() == null || !repo.existsById(s.getStdID())) {
			throw new StudentNotFoundException("Student " + s.getStdID() + " Not Exists");
		} else {
			repo.save(s);
		}
		
	}

	@Override
	public void deleteStudent(Integer id) {
		repo.delete(getOneStudent(id));
		
	}

	@Override
	public Student getOneStudent(Integer id) {
		return repo.findById(id).orElseThrow(() -> new StudentNotFoundException("Student " + id + " Not Exists"));
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> list = repo.findAll();
		return list; 
	}

}
