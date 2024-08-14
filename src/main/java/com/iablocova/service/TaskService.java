package com.iablocova.service;

import com.iablocova.dao.TaskDAO;
import com.iablocova.domain.Status;
import com.iablocova.domain.Task;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;

@Service
public class TaskService {

    private final TaskDAO taskDAO;

    public TaskService(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    public List<Task> getAll(int offset, int limit){
        return taskDAO.getAll(offset, limit);
    }

    public int getAllCount(){
        return taskDAO.getAllCount();
    }

    @Transactional
    public Task edit (int id, String description, Status status){
        Task task = taskDAO.getById(id);
        if(isNull(task)){
            throw new RuntimeException("Task not found");
        }

        task.setDescription(description);
        task.setStatus(status);
        taskDAO.saveOrUpdate(task);

        return task;
    }

    public Task create (String description, Status status){
         Task task = new Task();
         task.setDescription(description);
         task.setStatus(status);
         taskDAO.saveOrUpdate(task);
         return task;
    }

    @Transactional
    public void delete (int id){
        Task task = taskDAO.getById(id);
        if(isNull(task)){
            throw new RuntimeException("Task not found");
        }

        taskDAO.delete(task);
    }


}
