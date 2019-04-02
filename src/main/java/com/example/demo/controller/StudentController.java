package com.example.demo.controller;

import com.example.demo.modal.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriUtils;

import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping
public class StudentController {

  @Autowired
  StudentService studentService;

  @GetMapping(path = "/students", produces = "application/json")
  public HttpEntity findAllStudents() {
    List<Student> result = studentService.findAllStudents();

    return new ResponseEntity<>(result, HttpStatus.OK);
  }


  @GetMapping(path = "/students/{inputString}", produces = "application/json;charset=UTF-8")
  public HttpEntity findStudentsByName(@PathVariable("inputString")String name) {
    name = UriUtils.decode(name, StandardCharsets.UTF_8);
//    name = new String(name.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
    List<Student> result = studentService.findStudentsByName(name);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }
}
