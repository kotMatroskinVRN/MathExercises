package org.example;

import org.example.html.Page;
import org.example.mathoperation.MathOperation;
import org.example.mathoperation.MultiplicationTable;
import org.example.task.Exercise;
import org.example.task.TaskBuilder;
import org.example.task.TaskBuilderRandom;

public class Main  {

    public static void main(String[] args) {
        int limit = 10;

        if(args.length>0 ){
            int number = Integer.parseInt(args[0]);
            if(Math.abs(number)<10){
                limit = number;
            }

        }

        MathOperation mathOperation = new MultiplicationTable(limit);
        TaskBuilder taskBuilder = new TaskBuilderRandom(mathOperation , 65);

        taskBuilder.makeTask();
        Exercise exercise = taskBuilder.getExercise();
        exercise.getTasks().forEach(System.out::println);

        Page page = new Page(exercise);
        page.make();




    }


}
