package com.vinit.design.problems.logger;

public class InfoLogger extends AbstractLogger{

    protected InfoLogger(int level) {
        this.level = level;
    }
    @Override
    protected void display(String msg, LogSink logSink) {

        logSink.notifyObserver(2, "[INFO] - " + msg);
    }
}
