package com.example.teste_pratico.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_task")
public class TaskModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String description;

    private StatusEnum status = StatusEnum.PENDENTE;

    public void markAsConclued(){
        status = StatusEnum.CONCLUIDA;
    }

    public void markAsInProgress(){
        status = StatusEnum.EM_ANDAMENTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}
