package com.vinit.design.pattern.behavioral.chainOfResponsibility.Log;

import com.vinit.design.pattern.behavioral.chainOfResponsibility.enums.LogLevel;
import com.vinit.design.pattern.behavioral.chainOfResponsibility.sink.LogSinkI;

public class DebugLogProcessor implements LogProcessor {

    LogSinkI sink;
    LogProcessor nextLogProcessor;
    public DebugLogProcessor(LogSinkI sink, LogProcessor  next) {
        this.sink = sink;
        this.nextLogProcessor = next;
    }
    @Override
    public void log(LogLevel level, String message) {
        if (level.getLevel() <= LogLevel.DEBUG.getLevel()) {
            sink.log("DEBUG: " + message);
        }
        if (nextLogProcessor != null)
            nextLogProcessor.log(level, message);
    }
}
