package org.example.task;

import java.util.ArrayList;
import java.util.List;

public class Exercise {
    private final List<Task> tasks;
    private double averageWeight;

    public Exercise() {
        tasks = new ArrayList<>();
        averageWeight = 0;
    }

    public void addTask(Task task){
        tasks.add(task);
        averageWeight = countAverageWeight();
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public double getAverageWeight() {
        return averageWeight;
    }

    public Task findTaskByName(Task task){
        for(Task t : tasks){
            if(t.getText().equals(task.getText())){
                return t;
            }
        }
        return null;
    }

    private double countAverageWeight(){
        return tasks.stream().mapToInt(Task::getWeight).sum() / (double) tasks.size();
    }
}
