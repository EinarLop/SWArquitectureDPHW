package com.itesm.financial;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class RederDTOBuilder {
    InputStream inputStream;
    InputStreamReader streamReader;
    BufferedReader reader;

    public static RederDTOBuilder getBuilder() {
        return new RederDTOBuilder();
    }

    public RederDTOBuilder withInputStream(String CSV_FILENAME) {
        this.inputStream = Client.class.getClassLoader().getResourceAsStream(CSV_FILENAME);
        return this;
    }

    public RederDTOBuilder withStreamReader() {
        this.streamReader = new InputStreamReader(this.inputStream, StandardCharsets.UTF_8);
        return this;
    }

    public BufferedReader build() {
        return new BufferedReader(this.streamReader);
    }
}