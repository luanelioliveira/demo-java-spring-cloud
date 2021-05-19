package com.luanelioliveira.hrpayroll.repositories;

import com.luanelioliveira.hrpayroll.clients.WorkerClient;
import com.luanelioliveira.hrpayroll.models.Worker;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@RequiredArgsConstructor
@Repository
public class WorkerRepositoryImpl implements WorkerRepository {

  private final WorkerClient client;

  @HystrixCommand(fallbackMethod = "getWorkerByIdFallback")
  @Override
  public Optional<Worker> getWorkerById(Long id) {
    var worker = client.getWorkerById(id);
    return Optional.ofNullable(worker);
  }

  public Optional<Worker> getWorkerByIdFallback(Long id) {
    log.info("Calling getWorkerById fallback");

    var worker = new Worker(999L, "Brann", 400.0);
    return Optional.ofNullable(worker);
  }
}
