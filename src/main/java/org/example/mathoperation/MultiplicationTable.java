package org.example.mathoperation;

import org.example.task.Task;

public class MultiplicationTable implements MathOperation {
    private final int limit;

    public MultiplicationTable(int limit ) {
        this.limit = limit;
    }

    @Override
    public Task getRandomTask() {
        int a = (int)(Math.random()*(limit-1)) + 2;
        int b = (int)(Math.random()*8) + 2;


        return  new Task(String.format( FORMAT, a , "*" ,b));
    }

    @Override
    public int getNumerOfUniq() {
        return 8*(limit-1);
    }
}
