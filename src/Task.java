

public class Task {
    private int id;
    private String title;
    private String description;
    private Status status;

    public Task(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = Status.NEW;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "-название задачи: \"" + title + "\"\n" +
                "-описание задачи: \"" + description + "\"\n" +
                "- id задачи: " + id + "\n" +
                "- статус задачи: " + status +
                "\n";
    }
}
