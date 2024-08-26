package br.com.danielsilva.demo1.controller;


import br.com.danielsilva.demo1.domain.Task;
import br.com.danielsilva.demo1.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;


    @PostMapping("/tasks")
    @ResponseStatus(HttpStatus.CREATED)
    public Task createNewTask(@RequestBody Task task) {
        return taskService.createNewTask(task);
    }

    @GetMapping("/tasks")
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getAllTask(@RequestBody Task task) {
        return taskService.getAllTask();
    }

    @GetMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity <Task> findTaskById(@PathVariable (value = "id") Long id ){
        return taskService.findTaskById(id);
    }

    @PutMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity <Task> findTaskById(@PathVariable (value = "id") Long id, @RequestBody Task task ){
        return taskService.updateTaskById(id);
    }

    @DeleteMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity <Object> deleteTaskById(@PathVariable (value = "id") Long id ){
        return taskService.deleteTaskById(id);
    }





}
