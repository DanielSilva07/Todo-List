package br.com.danielsilva.demo1.controller;

import br.com.danielsilva.demo1.model.Task;
import br.com.danielsilva.demo1.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TaskController {

   private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @PostMapping("/new")
    public ResponseEntity<Task> createNewTask(@RequestBody Task task) {
        return ResponseEntity.status(201).body(taskService.createNewTask(task));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Task>>getAllTask(@RequestBody Task task) {
        return ResponseEntity.ok().body(taskService.getAll());
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task>findTaskById(@PathVariable (value = "id") Long id ){
        return taskService.findTaskById(id);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task>updateTaskById(@PathVariable (value = "id") Long id, @RequestBody Task task ){
        return taskService.updateTaskById(id);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity <Object> deleteTaskById(@PathVariable (value = "id") Long id ){
        return taskService.deleteTaskById(id);
    }





}
