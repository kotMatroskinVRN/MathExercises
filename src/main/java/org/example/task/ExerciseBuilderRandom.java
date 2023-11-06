package org.example.task;

import org.example.mathoperation.MathOperationTask;

import java.util.stream.IntStream;

public class ExerciseBuilderRandom implements ExerciseBuilder {
    private final Exercise exercise;
    private final int limit;

    private final MathOperationTask mathOperation ;

    public ExerciseBuilderRandom(MathOperationTask mathOperation , int tasksLimit) {
        this.mathOperation = mathOperation;
        exercise = new Exercise();
        limit = tasksLimit;
    }

    @Override
    public void makeExercise(){
        IntStream.range(0, limit).forEach(i -> makeSingleTask());
    }



    @Override
    public Exercise getExercise() {
        return exercise;
    }

    private void makeSingleTask(){

        Task task , inTest;
        int numberOfUniq = mathOperation.getNumerOfUniq();

        while(exercise.getTasks().size()<limit){
            task = mathOperation.getRandomTask();
            inTest = exercise.findTaskByName(task);

            double average = exercise.getAverageWeight();

            if(    inTest == null) {
//                task.addWeight();
                exercise.addTask(task);
                break;
            }else if( exercise.getTasks().size() >= numberOfUniq && inTest.getWeight() <= average  ){
                System.out.println( "elseif " + average);
                inTest.addWeight();
                exercise.addTask(inTest);
//                break;
            }
            //System.out.println(task);
            //System.out.println(inTest);
            //System.out.println(exercise.getTasks().size());
            //System.out.println(average);
        }
    }

}
