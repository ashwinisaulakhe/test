package com.springboot.first.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
	//http://localhost:8080/Student
	@GetMapping(path="/Student")
	public Student getStudent()
	{
		return new Student("Anish","saudagar");
		
	}
	//http://localhost:8080/students
	@GetMapping("/students")
	public List<Student> getStudents()
	{
		List<Student> students=new ArrayList<>();
		students.add(new Student("Danish","Khan"));
		students.add(new Student("Ashish","Kulkarni"));
		students.add(new Student("Arunita","Kanjilal"));
		students.add(new Student("Sayali","Kamble"));
		students.add(new Student("Nihal","Tauro"));
		return students;
		
	}
	//http://localhost:8080/Student/Arunita/Kanjilal
	//@path variable annotation
	@GetMapping("/Student/{firstName}/{lastName}")
	public Student studentPathVariable(@PathVariable ("firstName") String firstName,@PathVariable ("lastName") String lastName)
	{
		return new Student(firstName,lastName);
		
	}
	//build rest API to handle query parameters
	//http://localhost:8080/Student?firstName=Ashwini
	@GetMapping("/Student/query")
	public Student studentQueryParam(
			@RequestParam(name="firstName") String firstName, 
			@RequestParam(name="lastName")String lastName) {
		return new Student(firstName,lastName);
		
	}

}
