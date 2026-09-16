package controller;

import model.Task;

import java.io.IOException;
import java.util.ArrayList;

public class TaskController {

    private ArrayList<Task> taskList;
    private long id;
    FileController fileController = null;

    public TaskController() {
        taskList = new ArrayList<>();
        fileController = new FileController();
        // id = 0
    }

    // anadir tarea
    public boolean addTask(Task task) {
        // añadir una tarea
        // añadir un id a cada tarea y que este se autoasigne
        if (task.getTitle().equals("fallo")) {
            return false;
        }
        id++;
        task.setId(id);
        return taskList.add(task);
    }
    // listar tareas

    public void listTask() {

        taskList.stream().forEach(Task::showData);
        taskList.stream().filter(task ->  task.getPerson().getName().equals("nombre"))
                .toList().forEach(Task::showData);

        taskList.stream().filter(task -> task.getLevel()==1)
                .toList().forEach(Task::showData);

        taskList.stream().filter(Task::isComplete)
                .toList().forEach(Task::showData);

    }

    public void exportTask(){
        try {
            fileController.expotByMail(taskList, null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public void exportTaskByMail(String mail){
        try {
            fileController.expotByMail(taskList.stream().filter(
                    task -> task.getPerson().getEmail().equalsIgnoreCase(mail)).toList(),
                    mail);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}