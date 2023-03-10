package com.example.TacoCloud.entities;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

@Data
public class TacoOrder {

  @NotBlank(message = "Delivery name is required")
  private String deliveryName;

  @NotBlank(message = "Delivery street is required")
  private String deliveryStreet;

  @NotBlank(message = "Delivery city is required")
  private String deliveryCity;

  @NotBlank(message = "Delivery state is required")
  private String deliveryState;

  @NotBlank(message = "Delivery zip is required")
  private String deliveryZip;

  @CreditCardNumber(message = "Not a valid credit card number")
  private String ccNumber;

  @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])(1[2-9]|2[0-2])",
      message = "Must be formatted MM/YY")
  private String ccExpiration;

  @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
  private String ccCVV;
  private List<Taco> tacos = new ArrayList<>();

  public void addTaco(Taco taco) {
    this.tacos.add(taco);
  }

}
