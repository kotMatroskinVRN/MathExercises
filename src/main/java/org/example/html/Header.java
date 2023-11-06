package org.example.html;

public class Header {

    private final String title;
    private String html;

    public Header() {
        title = "Проверка таблицы умножения";
    }

    public Header(String title){
        this.title = title;
    }

    public void make(){
        html = "<H1>" + title + "<H1>";
    }

    public String getHtml() {
        return html;
    }
}
