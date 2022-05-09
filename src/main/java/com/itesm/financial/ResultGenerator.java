package com.itesm.financial;

import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;

public class ResultGenerator {

    BufferedReader reader;

    public void createBuilder(String CSV_FILENAME) {
        // Design Pattern 1: Builder
        RederDTOBuilder builder = RederDTOBuilder.getBuilder();
        builder.withInputStream(CSV_FILENAME);
        builder.withStreamReader();
        reader = builder.build();
    }

    public List<Ride> buildResult() throws Exception {
        List<Ride> result = new ArrayList<>();
        for (String rawLine; (rawLine = reader.readLine()) != null;) {
            List<String> line = CSVUtils.parseLine(rawLine);
            Ride newRide = RidesParser.parseFromList(line);
            if (newRide != null) {
                result.add(newRide);
            }
        }
        return result;
    }
}
