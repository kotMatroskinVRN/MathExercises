package org.example.html;

import org.example.task.Exercise;
import org.example.task.Task;

public class Table {

    private String table;
    private final Exercise exercise;
    public Table(Exercise exercise) {
        this.exercise = exercise;

    }

    public void makeTable(){
        StringBuilder stringBuilder = new StringBuilder("<table>\n<tr>");
        int counter = 1;
        for(Task task : exercise.getTasks()){

            String cell = makeCell(task.getText());

            if(counter%5==0){
                counter = 0;
                stringBuilder.append( cell );
                stringBuilder.append("</tr>\n<tr>");
            }else{
                stringBuilder.append( cell );
            }


            counter++;
        }

        stringBuilder.append("</tr>\n</table>");

        table = stringBuilder.toString();

    }

    public String getTable() {
        return table;
    }

    private String makeCell(String content ){
        return "<td>" + content + "</td><td>     </td>";
    }
}
