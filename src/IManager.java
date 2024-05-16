import java.util.List;


public interface IManager {

    List<Task> getAllTasks();
    List<Epic> getAllEpics();
    List<SubTask> getAllSubTasks();

    void removeAllTasks();
    void removeAllEpics();
    void removeAllSubTasks();


    Task getTaskById(int id);
    SubTask getSubtaskById(int id);
    Epic getEpicById(int id);


    void createTask(Task task);
    void createEpic(Epic epic);
    void createSubTask(SubTask subTask);

    void updateTask(int id, Task updatedTask);
    void updateEpic(int id, Epic updatedEpic);
    void updateSubTask(int id, SubTask updatedSubTask);


    void deleteTaskById(int id);
    void deleteEpicById(int id);
    void deleteSubTaskById(int id);

    void setStatusTask(Status status);
    void setStatusEpic(Status status);
    void setStatusSubTask(Status status);

}

