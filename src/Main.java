import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Task> taskList = new ArrayList<>();
        List<SubTask> subTaskList = new ArrayList<>();
        List<Epic> epicList = new ArrayList<>();
        TaskManager manager = new TaskManager(taskList, subTaskList, epicList);

        Task task = new Task(1, "task1", "to do task");
        Epic epic1 = new Epic(10, "epic1", "to do epic1");
        Epic epic2 = new Epic(20, "epic2", "to do epic2");
        SubTask subTask = new SubTask(100, "subtask", "to do subtask", epic1);
        manager.createEpic(epic1);
        manager.createSubTask(subTask);
        manager.createTask(task);
        System.out.println("Все Epic задачи:");
        for (Epic epic : manager.getAllEpics()) {
            System.out.println(epic);
        }

        manager.updateEpic(10, epic2);
        System.out.println(" Epic задачи после обновления:");
        for (Epic epic : manager.getAllEpics()) {
            System.out.println(epic);
        }

        System.out.println(manager.getAllTasks());
        System.out.println(manager.getAllSubTasks());
        InMemoryHistoryManager memoryHistoryManager = new InMemoryHistoryManager();

        memoryHistoryManager.add(task);
        memoryHistoryManager.add(epic1);
        memoryHistoryManager.add(epic2);
        System.out.println("_____________");
        for(Task t: memoryHistoryManager.getHistory()){
            System.out.println(t.toString());
        }
        memoryHistoryManager.remove(epic1.getId());
        System.out.println("_____________");
        for(Task t: memoryHistoryManager.getHistory()){
            System.out.println(t.toString());
        }


    }

}
