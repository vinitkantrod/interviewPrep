package com.vinit.design.problems.logger;

public class ErrorLogger extends AbstractLogger{

    protected ErrorLogger(int level) {
        this.level = level;
    }
    @Override
    protected void display(String msg, LogSink logSink) {
        logSink.notifyObserver(1, "[ERROR] - " + msg);
    }
}
