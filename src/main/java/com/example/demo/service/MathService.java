package com.example.demo.service;

import com.example.demo.modal.MathRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class MathService {
  public Long doCalculation(MathRequest mathRequest) {
    switch (mathRequest.getOperator()) {
      case "+" :
        return mathRequest.getA() + mathRequest.getB();
      case "-" :
        return mathRequest.getA() - mathRequest.getB();
      case "*" :
        return mathRequest.getA() * mathRequest.getB();
      case "/" :
        return mathRequest.getB() == 0 ? null : mathRequest.getA() / mathRequest.getB();
      default:
        return null;
    }
  }
}
