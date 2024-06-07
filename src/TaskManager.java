import java.util.ArrayList;
import java.util.List;

public class TaskManager implements IManager {
    private List<Task> taskList;
    private List<SubTask> subTaskList;
    private List<Epic> epicList;

    public TaskManager(List<Task> taskList, List<SubTask> subTaskList, List<Epic> epicList) {
        this.taskList = new ArrayList<>();
        this.subTaskList = new ArrayList<>();
        this.epicList = new ArrayList<>();
    }

    public TaskManager() {
    }

    @Override
    public List<Task> getAllTasks() {
        return taskList;
    }

    @Override
    public List<Epic> getAllEpics() {
        return epicList;
    }

    @Override
    public List<SubTask> getAllSubTasks() {
        return subTaskList;
    }


    @Override
    public void removeAllTasks() {
        taskList.clear();
    }

    @Override
    public void removeAllEpics() {
        epicList.clear();
    }

    @Override
    public void removeAllSubTasks() {
        for (Epic epic : epicList) {
            epic.getSubTaskList().clear();
        }
        subTaskList.clear();
    }

    @Override
    public Task getTaskById(int id) {
        for (Task task : taskList) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    @Override
    public SubTask getSubtaskById(int id) {
        for (SubTask subTask : subTaskList) {
            if (subTask.getId() == id) {
                return subTask;
            }
        }
        return null;}

    @Override
    public Epic getEpicById(int id) {
        for (Epic epic : epicList) {
            if (epic.getId() == id) {
                return epic;
            }
        }
        return null;
    }

    @Override
    public void createTask(Task task) {
        taskList.add(task);

    }

    @Override
    public void createEpic(Epic epic) {
        epicList.add(epic);

    }

    @Override
    public void createSubTask(SubTask subTask) {
        subTaskList.add(subTask);
        Epic epic = getEpicById(subTask.getEpic().getId());
        epic.getSubTaskList().add(subTask);
        setStatusEpic(Status.NEW);

    }

    @Override
    public void updateTask(int id, Task updatedTask) {
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getId() == id) {
                taskList.set(i, updatedTask);
                return;
            }
        }
        System.out.println("Задача с id " + id + " не найдена");

    }


    @Override
    public void updateEpic(int id, Epic updatedEpic) {
        for (int i = 0; i < epicList.size(); i++) {
            if (epicList.get(i).getId() == id) {
                epicList.set(i, updatedEpic);
                return;
            }
        }
        System.out.println("Epic задачи с id " + id + " не найдена");
    }


    @Override
    public void updateSubTask(int id, SubTask updatedSubTask) {
        for (int i = 0; i < subTaskList.size(); i++) {
            if (subTaskList.get(i).getId() == id) {
                subTaskList.set(i, updatedSubTask);
                return;
            }
        }
        System.out.println(" Подзадача с id " + id + " не найдена");
    }


    @Override
    public void deleteTaskById(int id) {
        Task taskForDelete = taskList.get(id);
        if (taskList.contains(taskForDelete)) {
            taskList.remove(taskForDelete);
        } else {
            System.out.println("Задачи с id " + id + " не существует");

        }

    }

    @Override
    public void deleteEpicById(int id) {
        Epic epicForDelete = epicList.get(id);
        List<SubTask> allEpicsSubTasks = getAllSubTasks();
        if (epicList.contains(epicForDelete)) {
            for (SubTask subTask : allEpicsSubTasks) {
                allEpicsSubTasks.clear();
            }
            epicList.remove(epicForDelete);
        } else {
            System.out.println("Epic задачи с id " + id + " не существует");
        }
    }

    @Override
    public void deleteSubTaskById(int id) {

        SubTask subTaskForDelete = subTaskList.get(id);
        int epicId = subTaskForDelete.getEpic().getId();
        Epic epic = epicList.get(epicId);
        epic.getSubTaskList().remove(subTaskForDelete);
    }

    @Override
    public void setStatusTask(Status status) {

    }

    @Override
    public void setStatusEpic(Status status) {

    }

    @Override
    public void setStatusSubTask(Status status) {

    }

}




