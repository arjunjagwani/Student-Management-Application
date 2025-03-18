package com.basic.projects.StudentManagementApp.controllers;

import com.basic.projects.StudentManagementApp.model.Student;
import com.basic.projects.StudentManagementApp.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public String getStudents(Model model){
        model.addAttribute("Students",studentService.getAllStudents());
        return "Students";

    }

    @GetMapping("/studentForm")
    public String studentForm(Model model){
        model.addAttribute("Students",new Student());
        return "student-form";

    }

    @PostMapping("/addStudent")
    public String addStudents(@RequestParam String first_name,@RequestParam String last_name,@RequestParam String email){

        studentService.addNewStudent(first_name, last_name, email);
        return "redirect:/";

    }
    @GetMapping("/{id}/delete")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "redirect:/";
    }
    @GetMapping("/updateForm/{id}")
    public String studentUpdateForm(@PathVariable Long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "student-update-form";
    }

    @PostMapping("/{id}/update")
    public String updateStudent(@PathVariable Long id,@ModelAttribute Student student){
        studentService.updateStudent(id, student);
        return "redirect:/";
    }



//    @PostMapping
//    public String addStudents(@RequestBody Student student){
//
//        studentService.addNewStudent(student.getFirst_name(), student.getLast_name(), student.getEmail());
//        return "redirect:/";
//
//    }
}
