package com.example.demo.modal;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MathRequest {
  private long a;
  private long b;
  private String operator;
}
