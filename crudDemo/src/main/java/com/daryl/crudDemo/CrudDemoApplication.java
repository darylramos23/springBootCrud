package com.daryl.crudDemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.daryl.crudDemo.DAO.StudentDAO;
import com.daryl.crudDemo.StudentDAOImpl;
import com.daryl.crudDemo.entity.Student;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAOImpl studentDAO){
		return run ->{
			//insertStudent(studentDAO);
			//System.out.println("Found it "+ getStudentRecord(studentDAO));
			//getListOfStudents(studentDAO);
			getAStudent(studentDAO,1);

		};
	}

	public void insertStudent(StudentDAO studentDAO){
		Student newStudent = new Student("Kathy","Ramos","KatherineCamigla.dr@gmail.com");

		studentDAO.save(newStudent);
		System.out.println("Success");
	}

	public Student getStudentRecord(StudentDAO studentDAO){
		Integer id = 1;
		return studentDAO.findById(id);

	}


	public void getListOfStudents(StudentDAO studentDAO){

		List<Student> theStudents = studentDAO.findAll();

		for(Student student:theStudents){
			System.out.println(student.toString());
		}
	}

	public void getAStudent(StudentDAOImpl studentDAO,Integer id){
		Student student = studentDAO.findById2(id);

		System.out.println(student);
	}
}
