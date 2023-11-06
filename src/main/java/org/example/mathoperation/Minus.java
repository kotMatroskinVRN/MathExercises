package org.example.mathoperation;

import org.example.task.Task;

public class Minus implements MathOperationTask {

    private final int limit;

    public Minus(int limit) {
        this.limit = limit;
    }

    @Override
    public Task getRandomTask() {
        int a = 0;
        int b = 1;

        while (a - b < 0){
            a = (int)(Math.random()*limit);
            b = (int)(Math.random()*a);
        }
        return  new Task(String.format( FORMAT, a , "-" , b ));

    }

    @Override
    public Task getParticularTask(int a, int b) throws ArithmeticException {
        if(a>limit || b>limit || a<b ) throw new ArithmeticException();
        return new Task(String.format( FORMAT, a , "-" , b ));
    }

    @Override
    public int getNumerOfUniq() {
        int countMinus = 0;

        for(int i=0;i<=limit;i++)
            for(int j = 0; j <= limit; j++)
                if(i - j >= 0) countMinus++;
        return countMinus;
    }

    @Override
    public int getLimit() {
        return limit;
    }

    @Override
    public String getHTMLtitle() {
        return "Вычитание Двухзначных чисел";
    }
}
