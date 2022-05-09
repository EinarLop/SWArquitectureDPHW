package com.itesm.financial;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Report implements ReportInterface {

    private ArrayList<String> headers;
    private String title;

    public Report(ArrayList<String> headers, String title) {
        this.headers = headers;
        this.title = title;
    }

    public ArrayList<String> getHeaders() {
        return headers;
    }

    public String getTitle() {
        return title;
    }

    public void getFile(String content, String filename) throws IOException {
        FileWriter fileWriter = new FileWriter(filename); // C
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(content);
        printWriter.close();
    }

}
