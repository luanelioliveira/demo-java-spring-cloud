package com.luanelioliveira.hrpayroll.resources;

import com.luanelioliveira.hrpayroll.models.Payment;
import com.luanelioliveira.hrpayroll.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentResource {

  private final PaymentService service;

  @GetMapping("/{workerId}/days/{days}")
  public ResponseEntity<Payment> getPaymentsWorker(@PathVariable Long workerId,
      @PathVariable Integer days) {
    var payment = service.getPayment(workerId, days);

    return ResponseEntity.ok(payment);
  }
}
