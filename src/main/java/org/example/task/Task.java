package org.example.task;

public class Task {
    private final String text;
    private int weight;

    public Task(String task) {
        this.text = task;
        weight = 0;
    }

    public void addWeight(){
        weight++;
    }

    public String getText() {
        return text;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Task{" +
                "text='" + text + '\'' +
                ", weight=" + weight +
                '}';
    }
}
