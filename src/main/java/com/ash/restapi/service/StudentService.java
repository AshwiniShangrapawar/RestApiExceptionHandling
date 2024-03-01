package com.ash.restapi.service;

import java.util.List;

import com.ash.restapi.entity.Student;

public interface StudentService {

	Integer saveStudent(Student s);

	void UpdateStudent(Student s);

	void deleteStudent(Integer id);

	Student getOneStudent(Integer id);

	List<Student> getAllStudents();

}
