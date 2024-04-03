package com.vinit.design.pattern.behavioral.chainOfResponsibility.Log;

import com.vinit.design.pattern.behavioral.chainOfResponsibility.enums.LogLevel;
import com.vinit.design.pattern.behavioral.chainOfResponsibility.sink.LogSinkI;

public class InfoLogProcessor implements LogProcessor {

    LogSinkI sink;
    LogProcessor nextLogProcessor;
    public InfoLogProcessor(LogSinkI sink, LogProcessor  next) {
        this.sink = sink;
        this.nextLogProcessor = next;
    }
    @Override
    public void log(LogLevel level, String message) {
        if (level.getLevel() <= LogLevel.INFO.getLevel()) {
            sink.log("INFO: " + message);
        }
        if (nextLogProcessor != null)
            nextLogProcessor.log(level, message);
    }
}
