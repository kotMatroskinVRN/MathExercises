package org.example.task;

import org.example.mathoperation.MathOperation;

import java.util.stream.IntStream;

public class TaskBuilderRandom implements  TaskBuilder {
    private final Exercise exercise;
    private final int limit;

    private final MathOperation mathOperation ;

    public TaskBuilderRandom(MathOperation mathOperation , int tasksLimit) {
        this.mathOperation = mathOperation;
        exercise = new Exercise();
        limit = tasksLimit;
    }

    @Override
    public void makeTask(){
        IntStream.range(0, limit).forEach(i -> makeSingleTask());
    }



    @Override
    public Exercise getExercise() {
        return exercise;
    }

    private void makeSingleTask(){

        Task task , inTest;
        int numberOfUniq = mathOperation.getNumerOfUniq();

        while(true){
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
                break;
            }
            //System.out.println(task);
            //System.out.println(inTest);
            //System.out.println(exercise.getTasks().size());
            //System.out.println(average);
        }
    }

}
