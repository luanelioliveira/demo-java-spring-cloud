package com.luanelioliveira.hrworker.resources;

import com.luanelioliveira.hrworker.models.Worker;
import com.luanelioliveira.hrworker.repositories.WorkerRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("workers")
@RequiredArgsConstructor
public class WorkerResource {

  private final WorkerRepository repository;

  @GetMapping
  public ResponseEntity<List<Worker>> getAllWorkers() {
    var allWorkers = repository.findAll();

    return ResponseEntity.ok(allWorkers);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Worker> getWorkerById(@PathVariable Long id) {
    var worker = repository.findById(id);

    if (worker.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(worker.get());
  }
}
