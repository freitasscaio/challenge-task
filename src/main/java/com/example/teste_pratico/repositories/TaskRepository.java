package com.example.teste_pratico.repositories;

import com.example.teste_pratico.model.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskModel, Long> {
}
