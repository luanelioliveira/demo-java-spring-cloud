package com.luanelioliveira.hrpayroll.repositories;

import com.luanelioliveira.hrpayroll.models.Worker;
import java.util.Optional;

public interface WorkerRepository {

  Optional<Worker> getWorkerById(Long id);
}
