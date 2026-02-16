package com.example.todolist.controller;

import com.example.todolist.model.Todo;
import com.example.todolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

@Controller
@RequiredArgsConstructor
public class TodoViewController {

    private final TodoService todoService;

    // Home page
    @GetMapping("/")
    public String viewTodos(Model model) {
        model.addAttribute("todos", todoService.getAllTodos());
        model.addAttribute("todo", new Todo());
        return "index";
    }

    // Add Todo
    @PostMapping("/add")
    public String addTodo(@Valid @ModelAttribute Todo todo,
                          BindingResult result,
                          Model model) {

        if (result.hasErrors()) {
            model.addAttribute("todos", todoService.getAllTodos());
            return "index";
        }

        todo.setCompleted(false);
        todoService.createTodo(todo);
        return "redirect:/";
    }


    // Toggle complete
    @GetMapping("/toggle/{id}")
    public String toggleTodo(@PathVariable String id) {
        Todo todo = todoService.getTodoById(id);
        if (todo != null) {
            todo.setCompleted(!todo.isCompleted());
            todoService.createTodo(todo);
        }
        return "redirect:/";
    }

    // Delete Todo
    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable String id) {
        todoService.deleteTodo(id);
        return "redirect:/";
    }
}
