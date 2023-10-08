package org.example.mathoperation;

import org.example.task.Task;

public class Plus implements MathOperation {
    private final int limit;

    public Plus(int limit) {
        this.limit = limit;
    }

    @Override
    public Task getRandomTask() {
        int a = limit;
        int b = limit;


        while (a + b > limit) {
            a = (int)(Math.random()*limit);
            b = (int)(Math.random()*(limit-a));
        }
        return  new Task(String.format( FORMAT, a , "+" ,b));
    }

    @Override
    public int getNumerOfUniq() {
        return 0;
    }
}
