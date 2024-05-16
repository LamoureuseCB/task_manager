import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Task> taskList = new ArrayList<>();
        List<SubTask> subTaskList = new ArrayList<>();
        List<Epic> epicList = new ArrayList<>();
        Manager manager = new Manager(taskList, subTaskList, epicList);

        Task task = new Task(1, "task1", "hhjg");
        Epic epic1 = new Epic(10,"Пjvhsjvsj","kjchsaj");
        Epic epic2 = new Epic(20,"shvsjvg","");
        SubTask subTask1 = new SubTask(100, "sxcbzxj","kjhsjkd",epic1);
        manager.createEpic(epic1);
        manager.createSubTask(subTask1);
        manager.createTask(task);
        System.out.println("Все Epic задачи:");
        for (Epic epic: manager.getAllEpics()) {
            System.out.println(epic);
        }
        manager.updateEpic(10, epic2);
        System.out.println(" Epic задачи после обновления:");
        for (Epic epic: manager.getAllEpics()) {
            System.out.println(epic);
        }

        System.out.println(manager.getAllTasks());
        System.out.println(manager.getAllSubTasks());

        }

    }
