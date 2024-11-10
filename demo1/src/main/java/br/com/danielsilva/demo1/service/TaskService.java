package br.com.danielsilva.demo1.service;

import br.com.danielsilva.demo1.model.Task;
import br.com.danielsilva.demo1.repository.TaskRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {


    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task createNewTask(Task task){
        return repository.save(task);
    }

    public List<Task>getAll(){
        return repository.findAll();
    }


    public ResponseEntity <Task> findTaskById(Long id) {
        return repository.findById(id)
                .map(task -> ResponseEntity.ok().body(task))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity <Task> updateTaskById(Long id) {
        return repository.findById(id)
                .map(taskupdate -> {
                    taskupdate.setNome(taskupdate.getNome());
                    taskupdate.setDescription(taskupdate.getDescription());
                    taskupdate.setCompleted(taskupdate.isCompleted());
                    taskupdate.setPrioridade(taskupdate.isPrioridade());
                    Task update = repository.save(taskupdate);
                    return ResponseEntity.ok().body(update);


                }).orElse(ResponseEntity.notFound().build());
    }


    public ResponseEntity<Object> deleteTaskById(Long id) {
        return repository.findById(id)
                .map(taskToDelete ->{
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
