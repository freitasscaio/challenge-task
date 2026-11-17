package com.example.teste_pratico.DTOS;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TaskDTO {

    @NotBlank
    @Size(max = 100, min = 3)
    private String title;

    @NotBlank
    @Size(max = 100)
    private String description;

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
}
