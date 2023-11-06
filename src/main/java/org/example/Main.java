package org.example;

import org.example.html.Page;
import org.example.mathoperation.MathOperationTask;
import org.example.mathoperation.Minus;
import org.example.mathoperation.MultiplicationTable;
import org.example.mathoperation.Plus;
import org.example.task.Exercise;
import org.example.task.ExerciseBuilder;
import org.example.task.ExerciseBuilderFast;

public class Main  {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        int limit = 10;

        if(args.length>0 ){
            int number = Integer.parseInt(args[0]);
            if(Math.abs(number)<10){
                limit = number;
            }

        }

        MathOperationTask mathOperation;
        ExerciseBuilder exerciseBuilder;
        Exercise exercise;
        Page page;

        mathOperation = new MultiplicationTable(limit);
        exerciseBuilder   = new ExerciseBuilderFast(mathOperation , 65);
        exerciseBuilder.makeExercise();
        exercise = exerciseBuilder.getExercise();
        page = new Page(exercise ,mathOperation , "YuliaMultiTable.html" );
        page.make();
//        exercise.getTasks().forEach(System.out::println);

        mathOperation = new Plus(100);
        exerciseBuilder   = new ExerciseBuilderFast(mathOperation , 65);
        exerciseBuilder.makeExercise();
        exercise      = exerciseBuilder.getExercise();
        page = new Page(exercise , mathOperation , "YuliaPlus.html" );
        page.make();
//        exercise.getTasks().forEach(System.out::println);

        mathOperation = new Minus(100);
        exerciseBuilder   = new ExerciseBuilderFast(mathOperation , 65);
        exerciseBuilder.makeExercise();
        exercise      = exerciseBuilder.getExercise();
        page = new Page(exercise , mathOperation , "YuliaMinus.html" );
        page.make();
//        exercise.getTasks().forEach(System.out::println);


        double time  = (System.currentTimeMillis() - start)/1000.0 ;
        System.out.printf( "run time : %f seconds\n" , time );


    }


}
