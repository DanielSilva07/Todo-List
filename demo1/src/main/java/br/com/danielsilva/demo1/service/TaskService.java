package br.com.danielsilva.demo1.service;

import br.com.danielsilva.demo1.domain.Task;
import br.com.danielsilva.demo1.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
@RequiredArgsConstructor
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createNewTask(Task task){
        return taskRepository.save(task);
    }

    public List<Task> getAllTask() {
        return (List<Task>) taskRepository.findAll();
    }


    public ResponseEntity <Task> findTaskById(Long id) {
        return taskRepository.findById(id)
                .map(task -> ResponseEntity.ok().body(task))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity <Task> updateTaskById(Long id) {
        return taskRepository.findById(id)
                .map(taskupdate -> {
                    taskupdate.setNome(taskupdate.getNome());
                    taskupdate.setDescription(taskupdate.getDescription());
                    taskupdate.setCompleted(taskupdate.isCompleted());
                    taskupdate.setPrioridade(taskupdate.isPrioridade());
                    Task update = taskRepository.save(taskupdate);
                    return ResponseEntity.ok().body(update);


                }).orElse(ResponseEntity.notFound().build());
    }


    public ResponseEntity<Object> deleteTaskById(Long id) {
        return taskRepository.findById(id)
                .map(taskToDelete ->{
            taskRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
