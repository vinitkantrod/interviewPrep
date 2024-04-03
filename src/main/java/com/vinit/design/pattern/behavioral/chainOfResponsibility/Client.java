package com.vinit.design.pattern.behavioral.chainOfResponsibility;

import com.vinit.design.pattern.behavioral.chainOfResponsibility.Log.*;
import com.vinit.design.pattern.behavioral.chainOfResponsibility.enums.LogLevel;
import com.vinit.design.pattern.behavioral.chainOfResponsibility.sink.ConsoleSink;
import com.vinit.design.pattern.behavioral.chainOfResponsibility.sink.LogSinkI;
import com.vinit.design.problems.logger.LogSink;

/**
 * Chain of responsibility Design Pattern::
 *
 * behavioral Design Pattern
 *
 * lets you pass requests along a chain of handlers.
 * Upon receiving a request, each handler decides
 * either to process the request or to pass it
 * to the next handler in the chain.
 */
public class Client {

    public static void main(String[] args) {
        LogSinkI logSink = new ConsoleSink();
        ErrorLogProcessor error = new ErrorLogProcessor(logSink, null);
        WarningLogProcessor warning = new WarningLogProcessor(logSink, error);
        InfoLogProcessor info = new InfoLogProcessor(logSink, warning);
        TraceLogProcessor trace = new TraceLogProcessor(logSink, info);
        DebugLogProcessor debug = new DebugLogProcessor(logSink, trace);

        error.log(LogLevel.ERROR, "Trace Error");
        warning.log(LogLevel.WARNING, "Warning Error");
        info.log(LogLevel.INFO, "Info Error");
        trace.log(LogLevel.TRACE, "Trace Error");
        debug.log(LogLevel.DEBUG, "De-bug Error");
    }
}
