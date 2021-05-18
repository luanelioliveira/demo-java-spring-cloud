package com.luanelioliveira.hrpayroll.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Worker {

  private Long id;
  private String name;
  private Double dailyIncome;
}
