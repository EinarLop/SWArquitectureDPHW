package com.itesm.financial;

import java.util.ArrayList;
import java.io.IOException;

public interface ReportInterface {
    ArrayList<String> getHeaders();

    String getTitle();

    void getFile(String content, String filename) throws IOException;

}
