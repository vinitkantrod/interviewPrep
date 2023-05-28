package com.vinit.design.problems.logger;

public class ConsoleSink implements LogObserver{
    @Override
    public void log(String msg) {
        System.out.println("CONSOLE: " + msg);
    }
}
