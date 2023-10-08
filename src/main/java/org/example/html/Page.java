package org.example.html;

import org.example.task.Exercise;
import org.example.utilities.StringResource;
import org.example.utilities.TextFileMaker;

public class Page {
    private final Header header;
    private final Table table;

    private String content;

    public Page(Exercise exercise) {
        header = new Header();
        table  = new Table(exercise);
    }

    public void make(){
        header.make();
        table.makeTable();


        StringResource stringResource = new StringResource();
        content = stringResource.resource2string("template.html");
        content = content.replaceAll("REPLACE_HEADER" , header.getHtml());
        content = content.replaceAll("REPLACE_TABLE"  , table.getTable());

        TextFileMaker textFileMaker = new TextFileMaker("YuliaMultiTable.html" , content);
        textFileMaker.make();
    }


}
