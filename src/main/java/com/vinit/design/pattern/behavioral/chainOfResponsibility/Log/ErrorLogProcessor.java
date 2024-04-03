package com.vinit.design.pattern.behavioral.chainOfResponsibility.Log;

import com.vinit.design.pattern.behavioral.chainOfResponsibility.enums.LogLevel;
import com.vinit.design.pattern.behavioral.chainOfResponsibility.sink.LogSinkI;

public class ErrorLogProcessor implements LogProcessor {

    LogSinkI sink;
    LogProcessor nextLogProcessor;
    public ErrorLogProcessor(LogSinkI sink, LogProcessor  next) {
        this.sink = sink;
        this.nextLogProcessor = next;
    }
    @Override
    public void log(LogLevel level, String message) {
        if (level.getLevel() <= LogLevel.ERROR.getLevel()) {
            sink.log("ERROR: " + message);
        }
        if (nextLogProcessor != null)
            nextLogProcessor.log(level, message);
    }
}
