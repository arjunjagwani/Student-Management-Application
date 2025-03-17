package com.basic.projects.StudentManagementApp.services;

import com.basic.projects.StudentManagementApp.model.Student;
import com.basic.projects.StudentManagementApp.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addNewStudent(String first_name,String last_name, String email){
        Student student=new Student(first_name,last_name,email);
        studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void deleteStudent(Long id) {
    studentRepository.deleteById(id);

    }
}
