package org.example.task;

import org.example.mathoperation.MathOperationTask;

import java.util.Collections;
import java.util.stream.IntStream;

public class ExerciseBuilderFast implements ExerciseBuilder {
    private final Exercise exercise;
    private final int limit;

    private int numberOfUniq;

    private final MathOperationTask mathOperation ;

    public ExerciseBuilderFast(MathOperationTask mathOperation , int tasksLimit) {
        this.mathOperation = mathOperation;
        exercise = new Exercise();
        limit = tasksLimit;
    }

    @Override
    public void makeExercise(){

        numberOfUniq = mathOperation.getNumerOfUniq();

        if(numberOfUniq<=limit) sortThrough();
        IntStream.range(0, limit-exercise.getTasks().size()).forEach(i -> fillExercise());
        Collections.shuffle(exercise.getTasks());
    }




    @Override
    public Exercise getExercise() {
        return exercise;
    }


    private void sortThrough() {
        for(int a=0;a<=mathOperation.getLimit();a++){
            for(int b=0;b<=mathOperation.getLimit();b++){
                try {
                    if(exercise.getTasks().size() <= numberOfUniq ){
                        Task task = mathOperation.getParticularTask(a,b);
                        exercise.addTask(task);
                    }else{
                        break;
                    }

                }catch (ArithmeticException ignored){
                }
            }
        }
    }
    private void fillExercise(){

        Task task , inTest;

        while(exercise.getTasks().size()<limit){
            task = mathOperation.getRandomTask();
            inTest = exercise.findTaskByName(task);

            double average = exercise.getAverageWeight();

            if(    inTest == null) {
                exercise.addTask(task);
                break;
            }else if( exercise.getTasks().size() >= numberOfUniq && inTest.getWeight() <= average  ){
                System.out.println( "elseif " + average);
                inTest.addWeight();
                exercise.addTask(inTest);
            }
        }


    }

}
