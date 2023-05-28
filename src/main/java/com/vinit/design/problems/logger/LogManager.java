package com.vinit.design.problems.logger;

public class LogManager {

    static AbstractLogger doChaining() {
        AbstractLogger infoLogger = new InfoLogger(1);
        AbstractLogger errorLogger = new ErrorLogger(2);
        AbstractLogger debugLogger = new DebugLogger(3);
        infoLogger.setNextLevelLogger(errorLogger);
        errorLogger.setNextLevelLogger(debugLogger);

        return infoLogger;
    }

    static LogSink addLogObserver() {
        LogSink logSink = new LogSink();
        ConsoleSink consoleSink = new ConsoleSink();
        FileSink fileSink = new FileSink();
        logSink.addObserver(2, consoleSink);
        logSink.addObserver(1, fileSink);
        logSink.addObserver(2, fileSink);
        logSink.addObserver(3, consoleSink);
        return logSink;
    }
}
