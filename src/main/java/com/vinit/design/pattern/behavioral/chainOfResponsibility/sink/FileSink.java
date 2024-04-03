package com.vinit.design.pattern.behavioral.chainOfResponsibility.sink;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileSink implements LogSinkI {
    public static final String FILE_NAME = "CoR_test.txt";
    @Override
    public void log(String message) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
            writer.write(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
