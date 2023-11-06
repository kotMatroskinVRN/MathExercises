package org.example.html;

import org.example.mathoperation.MathOperationTask;
import org.example.task.Exercise;
import org.example.utilities.StringResource;
import org.example.utilities.TextFileMaker;

public class Page {
    private final Header header;
    private final Table table;

    private final String fileName;

    public Page(Exercise exercise , MathOperationTask mathOperationTask) {
        header = new Header(mathOperationTask.getHTMLtitle());
        table  = new Table(exercise);
        fileName = "YuliaMultiTable.html";
    }

    public Page(Exercise exercise , MathOperationTask mathOperationTask , String fileName) {
        header = new Header(mathOperationTask.getHTMLtitle());
        table  = new Table(exercise);
        this.fileName = fileName;
    }

    public void make(){
        header.make();
        table.makeTable();


        StringResource stringResource = new StringResource();
        String content = stringResource.resource2string("template.html");
        content = content.replaceAll("REPLACE_HEADER" , header.getHtml());
        content = content.replaceAll("REPLACE_TABLE"  , table.getTable());

        TextFileMaker textFileMaker = new TextFileMaker(fileName , content);
        textFileMaker.make();
    }


}
