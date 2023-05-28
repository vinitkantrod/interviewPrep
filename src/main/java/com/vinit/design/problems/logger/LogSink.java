package com.vinit.design.problems.logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogSink {

    Map<Integer, List<LogObserver>> logObservers = new HashMap<>();
    void addObserver(int level, LogObserver logObserver) {
        List<LogObserver> logObserverList = logObservers.getOrDefault(level, new ArrayList<>());
        logObserverList.add(logObserver);
        logObservers.put(level, logObserverList);
    }

    void notifyObserver(int level, String msg) {
        for (Map.Entry<Integer, List<LogObserver>> map : logObservers.entrySet()) {
            if (map.getKey() == level) {
                map.getValue().forEach(logObserver -> logObserver.log(msg));
            }
        }
    }
}
