public class TaskMapper {

    public static void update(Task currentTask, Task updatedTask) {
        if (updatedTask.getTitle() != null) {
            currentTask.setTitle(updatedTask.getTitle());
        }
    }
}
