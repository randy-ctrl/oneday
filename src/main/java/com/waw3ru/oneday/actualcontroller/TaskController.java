package com.waw3ru.oneday.actualcontroller;

import com.waw3ru.oneday.model.Task;
import com.waw3ru.oneday.repository.TaskRepository; 
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController 
@RequestMapping("/api/tasks")

public class TaskController {
    
    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskRepository.save(task);
        
    }


@GetMapping("/{id}")
public Task getTaskById(@PathVariable Long id) {
    return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
}
@PutMapping("/{id}")
public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
    Task existingTask = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    existingTask.setTitle(updatedTask.getTitle());
    existingTask.setCompleted(updatedTask.isCompleted());
    return taskRepository.save(existingTask);
}

@DeleteMapping("/{id}")
public void deleteTask(@PathVariable Long id) {
    if(!taskRepository.existsById(id)) {
        throw new RuntimeException("Task not found");
    }
    taskRepository.deleteById(id);
}

}
