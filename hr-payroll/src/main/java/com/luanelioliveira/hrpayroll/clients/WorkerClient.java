package com.luanelioliveira.hrpayroll.clients;

import com.luanelioliveira.hrpayroll.models.Worker;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@RibbonClient(name = "hr-worker")
@FeignClient(name = "hr-worker", path = "/workers")
public interface WorkerClient {

  @GetMapping("/{id}")
  Worker getWorkerById(@PathVariable Long id);
}
