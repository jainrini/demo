package appstart.models;

import java.util.List;

public class TasksOfGame {
    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public Task getBestTask() {
        return bestTask;
    }

    public void setBestTask(Task bestTask) {
        this.bestTask = bestTask;
    }

    public List<Task> getAllTask() {
        return allTask;
    }

    public void setAllTask(List<Task> allTask) {
        this.allTask = allTask;
    }

    private String gameId;
    private Task bestTask;
    private List<Task> allTask;

    public TasksOfGame(String gameId, Task bestTask, List<Task> allTask) {
        this.gameId = gameId;
        this.bestTask = bestTask;
        this.allTask = allTask;
    }
}
