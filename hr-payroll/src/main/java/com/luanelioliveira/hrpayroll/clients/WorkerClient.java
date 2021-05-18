package com.luanelioliveira.hrpayroll.clients;

import com.luanelioliveira.hrpayroll.models.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "worker", url = "http://localhost:8001", path = "/workers")
public interface WorkerClient {

  @GetMapping("/{id}")
  Worker getWorkerById(@PathVariable Long id);
}
