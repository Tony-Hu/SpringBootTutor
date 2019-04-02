package com.example.demo.repository;

import com.example.demo.modal.Student;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class StudentRepository {

  private List<Student> mockStudentsList;

  public StudentRepository() {
    mockStudentsList = new LinkedList<>();

    Student student1 = Student.builder().firstName("大胖").lastName("张")
        .gender("male").id("250").major("Computer Science").build();
    mockStudentsList.add(student1);
    Student student2 = Student.builder().firstName("Bill").lastName("Gates")
        .gender("female").id("001").major("Computer Engineering").build();
    mockStudentsList.add(student2);
    Student student3 = Student.builder().firstName("大胖").lastName("李")
        .gender("male").id("999").major("MBA").build();
    mockStudentsList.add(student3);
  }

  public List<Student> findAllStudents() {
    return mockStudentsList;
  }

  public List<Student> findStudentsByName(String name) {
    List<Student> result = new LinkedList<>();
    if (name == null || name.length() == 0) {
      return result;
    }

    for (Student student : mockStudentsList) {
      if (name.contains(student.getFirstName()) || name.contains(student.getLastName())) {
        result.add(student);
      }
    }
    return result;
  }
}
