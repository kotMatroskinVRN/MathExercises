package org.example.mathoperation;

import org.example.task.Task;

public class MultiplicationTable implements MathOperationTask {

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
    public Task getParticularTask(int a, int b) throws ArithmeticException {
        if(a>limit || b> limit || a<2 || b<2 ) throw new ArithmeticException();

        return new Task(String.format( FORMAT, a , "*" ,b));
    }

    @Override
    public int getNumerOfUniq() {
        return 8*(limit-1);
    }

    @Override
    public int getLimit() {
        return limit;
    }

    @Override
    public String getHTMLtitle() {
        return "Проверка таблицы умножения";
    }
}
