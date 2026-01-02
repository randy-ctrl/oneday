package com.waw3ru.oneday.repository;

import com.waw3ru.oneday.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    
}
