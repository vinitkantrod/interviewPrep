package com.vinit.dsalgo.hashtable.leetcode;


import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter359 {
    public static void main(String[] args)  {
        Logger logger = new Logger();
        logger.shouldPrintMessage(1, "foo");
        logger.shouldPrintMessage(2, "bar");
        logger.shouldPrintMessage(3, "foo");
        logger.shouldPrintMessage(4, "foo");
        logger.shouldPrintMessage(10, "foo");
        logger.shouldPrintMessage(11, "bar");
        logger.shouldPrintMessage(11, "foo");
    }
}

class Logger {

    Map<String, Integer> loggerMap;
    public Logger() {
        loggerMap = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (loggerMap.containsKey(message)) {
            int oldTimestamp = loggerMap.get(message);
            if (timestamp - oldTimestamp < 10) return false;
            else {
                loggerMap.put(message, timestamp);
                return true;
            }
        } else {
            loggerMap.put(message, timestamp);
            return true;
        }
    }
}
