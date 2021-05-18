package com.luanelioliveira.hrpayroll.services;

import com.luanelioliveira.hrpayroll.models.Payment;
import com.luanelioliveira.hrpayroll.repositories.WorkerRepository;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PaymentService {

  private final WorkerRepository workers;

  public Payment getPayment(long workerId, int days) {

    return workers
        .getWorkerById(workerId)
        .map(worker -> new Payment(worker.getName(), worker.getDailyIncome(), days))
        .orElseThrow(() -> new NoSuchElementException("Worker not found"));
  }
}
