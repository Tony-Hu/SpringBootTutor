package com.example.demo.controller;

import com.example.demo.modal.MathRequest;
import com.example.demo.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MathController {

  @Autowired
  MathService mathService;

  @PostMapping(path= "/math", produces = "application/json")
  public HttpEntity<Long> doMath(@RequestBody @NonNull MathRequest mathRequest) {
    Long result = mathService.doCalculation(mathRequest);

    HttpStatus status = result == null ? HttpStatus.BAD_REQUEST : HttpStatus.OK;
    return new ResponseEntity<>(result, status);
  }
}
