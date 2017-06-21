package com.praveen.praveen.datastructures.trees.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReadStudentData {
	
	private final StudentRepository studentRepository;
	
	@Autowired
	public ReadStudentData(final StudentRepository repository) {
		this.studentRepository = repository;
	}
	
	public Student saveStudent(){
		Student student = new Student();
		student.setName("praveen");
		student.setNumberOfEmployee(10);
		this.studentRepository.save(student);
		return student;
	}
	
	
}
