package com.scerbet.dam.taskmanager.model;

import org.springframework.data.annotation.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "tasks")
public class Task {

    @Id
    String id; // Gestionado por MongoDB

    @NotNull
    @Size(min = 1, max = 100, message = "El título debe tener entre 1 y 100 caracteres")
    String title;

    @Size
    String description;

    @NotNull
    boolean completed;

    @NotNull
    Priority priority;

    @NotNull
    List<String> tags;

    @NotNull
    String category;

    // Sin @NotNull porque se asigna en el Service al crear
    LocalDateTime createdAt;

    // Sin @NotNull porque se asigna en el Service al crear/editar
    LocalDateTime updatedAt;

    @NotNull
    LocalDateTime dueDate;
}