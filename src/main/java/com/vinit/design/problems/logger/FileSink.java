package com.vinit.design.problems.logger;

public class FileSink implements LogObserver{
    @Override
    public void log(String msg) {
        System.out.println("FILE: " + msg);
    }
}
