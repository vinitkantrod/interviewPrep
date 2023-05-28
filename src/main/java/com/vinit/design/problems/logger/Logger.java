package com.vinit.design.problems.logger;

import java.io.Serializable;
import static com.vinit.design.problems.logger.LogManager.doChaining;
import static com.vinit.design.problems.logger.LogManager.addLogObserver;
public class Logger implements Cloneable, Serializable {

    private volatile static Logger logger;
    private volatile static AbstractLogger chainOfLogging;

    private volatile static LogSink logSink;
    private Logger() {
        if (logger != null) throw new IllegalStateException("Logger already created!");
    }

    // Singleton Design Pattern
    public static Logger getLogger() {
        if (logger == null) {
            synchronized (Logger.class) {
                if (logger == null) {
                    logger = new Logger();
                    chainOfLogging = doChaining();
                    logSink = addLogObserver();
                }
            }
        }
        return logger;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    protected Object readResolve() {
        return logger;
    }

    public void info(String msg) {
        createLog(2, msg);
    }
    public void error(String msg) {
        createLog(1, msg);
    }

    public void debug(String msg) {
        createLog(3, msg);
    }

    private void createLog(int level, String msg) {
        chainOfLogging.logMessage(level, msg, logSink);
    }
}
