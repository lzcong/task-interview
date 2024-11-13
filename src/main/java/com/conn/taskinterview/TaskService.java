package com.conn.taskinterview;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private List<Task> taskList = new ArrayList<>();

    private int id = 1;

    public List<Task> getTaskList() {
        return taskList;
    }

    public Task getTaskById(int id) {
        return taskList.stream().filter(task -> task.getId() == id).findFirst().orElse(null);
    }

    public Task createTask(Task task) {
        task.setId(id);
        id++;
        taskList.add(task);
        return task;
    }

    public Task updateTask(Integer id, Task task) {
        Task oldTask = getTaskById(id);
        oldTask.setTitle(task.getTitle());
        oldTask.setDescription(task.getDescription());
        oldTask.setStatus(task.getStatus());
        return oldTask;
    }

    public Boolean deleteTask(int id) {
        Task task = getTaskById(id);
        if (task == null) {
            return false;
        }
        taskList.remove(task);
        return true;
    }

}
