package com.luanelioliveira.hrpayroll.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

  private String name;
  private Double dailyIncome;
  private Integer days;

  public double getTotal() {
    return this.dailyIncome * this.days;
  }


}
