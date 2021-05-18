package com.luanelioliveira.hrpayroll.repositories;

import com.luanelioliveira.hrpayroll.clients.WorkerClient;
import com.luanelioliveira.hrpayroll.models.Worker;
import feign.FeignException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class WorkerRepositoryImpl implements WorkerRepository {

  private final WorkerClient client;

  @Override
  public Optional<Worker> getWorkerById(Long id) {

    try {
      var worker = client.getWorkerById(id);
      return Optional.ofNullable(worker);
    } catch (FeignException exception) {
      if (exception.status() != 404) throw exception;
      return Optional.empty();
    }
  }
}
