package org.example.utilities;


import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TextFileMaker {

    private final String text;
    private final String name;

    public TextFileMaker(String name ,String text) {
        this.text = text;
        this.name = name;
    }

    public void make(){
        try (PrintWriter out = new PrintWriter(name)) {
            out.println(text);
        } catch (FileNotFoundException e) {
            System.exit(1);
        }

    }
}
