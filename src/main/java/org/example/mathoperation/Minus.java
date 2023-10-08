package org.example.mathoperation;

import org.example.task.Task;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Minus implements MathOperation{

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
    public int getNumerOfUniq() {
        return 0;
    }
}
