package org.example.mathoperation;

import org.example.task.Task;



public interface MathOperationTask {

    String FORMAT = "%-5d %-2s %-5d =";
    Task getRandomTask();
    Task getParticularTask(int a , int b) throws ArithmeticException;
    int getNumerOfUniq();
    int getLimit();
    String getHTMLtitle();
}
