package com.luanelioliveira.hrworker.repositories;

import com.luanelioliveira.hrworker.models.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {}
