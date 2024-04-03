package com.vinit.design.pattern.behavioral.chainOfResponsibility.sink;

public class ConsoleSink implements LogSinkI {
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
