package org.example.mathoperation;

import org.example.task.Task;

public class Plus implements MathOperationTask {
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
    public Task getParticularTask(int a, int b) throws ArithmeticException{
        if(a+b>limit) throw new ArithmeticException();
        return new Task(String.format( FORMAT, a , "+" ,b));
    }

    @Override
    public int getNumerOfUniq() {
        int countPlus  = 0;

        for(int i=0;i<=limit;i++)
            for(int j=0;j<=limit;j++)
                if(i+j<=limit) countPlus++;

        return countPlus;
    }

    @Override
    public int getLimit() {
        return limit;
    }

    @Override
    public String getHTMLtitle() {
        return "Сложение Двухзначных чисел";
    }
}
