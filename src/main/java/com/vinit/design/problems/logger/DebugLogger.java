package com.vinit.design.problems.logger;

public class DebugLogger extends AbstractLogger{

    protected DebugLogger(int level) {
        this.level = level;
    }
    @Override
    protected void display(String msg, LogSink logSink) {
        logSink.notifyObserver(3, "[DEBUG] - " + msg);
    }
}
