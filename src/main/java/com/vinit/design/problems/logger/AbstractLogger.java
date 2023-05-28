package com.vinit.design.problems.logger;

public abstract class AbstractLogger {
    int level;
    AbstractLogger nextLevelLogger;

    public void setNextLevelLogger(AbstractLogger nextLevelLogger) {
        this.nextLevelLogger = nextLevelLogger;
    }
    void logMessage(int levels, String msg, LogSink logSink) {
        if (this.level == levels) {
            display(msg, logSink);
        }
        if (nextLevelLogger != null) {
            nextLevelLogger.logMessage(levels, msg, logSink);
        }
    }

    protected abstract void display(String msg, LogSink logSink);
}
