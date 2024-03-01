package com.ash.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ash.restapi.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
