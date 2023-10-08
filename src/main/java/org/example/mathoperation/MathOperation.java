package org.example.mathoperation;

import org.example.task.Task;



public interface MathOperation {

    String FORMAT = "%-5d %-2s %-5d =";
    Task getRandomTask();
    int getNumerOfUniq();
}
