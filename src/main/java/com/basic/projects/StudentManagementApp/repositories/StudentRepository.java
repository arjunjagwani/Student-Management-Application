package com.basic.projects.StudentManagementApp.repositories;

import com.basic.projects.StudentManagementApp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
