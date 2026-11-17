package com.example.teste_pratico.controller;

import com.example.teste_pratico.DTOS.TaskDTO;
import com.example.teste_pratico.model.StatusEnum;
import com.example.teste_pratico.model.TaskModel;
import com.example.teste_pratico.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody TaskDTO taskDTO){
        var task = new TaskModel();
        BeanUtils.copyProperties(taskDTO, task);
        taskService.save(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    @PostMapping("/{id}/conclued")
    public ResponseEntity<Object> updateStatusConclued(@PathVariable Long id){
        Optional<TaskModel> taskId = taskService.findById(id);
        if(taskId.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }

        TaskModel taskModel = taskId.get();
        TaskModel taskUpdate = taskService.markAsConclued(taskModel);


        taskService.markAsConclued(taskModel);

        return ResponseEntity.status(HttpStatus.OK).body(taskUpdate);
    }

    @PostMapping("/{id}/inProgress")
    public ResponseEntity<Object> updateStatusInProgress(@PathVariable Long id){
        Optional<TaskModel> taskId = taskService.findById(id);
        if(taskId.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }

        TaskModel taskModel = taskId.get();
        TaskModel taskUpdate = taskService.markAsInProgress(taskModel);

        taskService.markAsInProgress(taskModel);

        return ResponseEntity.status(HttpStatus.OK).body(taskUpdate);
    }

    @GetMapping
    public ResponseEntity<List<TaskModel>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(taskService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id){
        Optional<TaskModel> taskId = taskService.findById(id);
        if(taskId.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(taskId.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateId(@PathVariable Long id, @Valid @RequestBody TaskDTO taskDTO){
        Optional<TaskModel> taskId = taskService.findById(id);
        if(taskId.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }

        TaskModel taskModel = taskId.get();

        if(taskModel.getStatus() == StatusEnum.CONCLUIDA){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tarefa não pode ser alterada, já foi concluída.");
        }

        BeanUtils.copyProperties(taskDTO, taskModel);

        return ResponseEntity.status(HttpStatus.OK).body(taskService.save(taskModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTask(@PathVariable Long id){
        Optional<TaskModel> taskId = taskService.findById(id);
        if(taskId.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }

        taskService.delete(taskId.get());
        return ResponseEntity.noContent().build();
    }

}
