package com.example.todolist.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TodoDto {

    @NotBlank(message = "Todo title cannot be empty")
    @Size(min = 3, max = 50, message = "Title must be 3–50 characters")
    private String title;
}
