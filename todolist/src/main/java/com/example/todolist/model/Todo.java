package com.example.todolist.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "todos")
public class Todo {

    @Id
    private String id;

    @NotBlank(message = "Todo title cannot be empty")
    @Size(min = 3, max = 50, message = "Title must be between 3 and 50 characters")
    private String title;

    private boolean completed;
}
