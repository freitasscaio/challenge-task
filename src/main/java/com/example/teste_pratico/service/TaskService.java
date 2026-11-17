package com.example.teste_pratico.service;

import com.example.teste_pratico.model.TaskModel;
import com.example.teste_pratico.repositories.TaskRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public TaskModel save(TaskModel taskModel){
        return taskRepository.save(taskModel);
    }

    public List<TaskModel> findAll(){
        return taskRepository.findAll();
    }

    public Optional<TaskModel> findById(Long id){
        return taskRepository.findById(id);
    }

    public void delete(TaskModel taskModel){
        taskRepository.delete(taskModel);
    }

    public TaskModel markAsConclued(TaskModel taskModel){
        taskModel.markAsConclued();
        return taskRepository.save(taskModel);
    }

    public TaskModel markAsInProgress(TaskModel taskModel){
        taskModel.markAsInProgress();
        return taskRepository.save(taskModel);
    }

}
