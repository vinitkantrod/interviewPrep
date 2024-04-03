package com.vinit.design.problems.logClient;

import java.util.*;

public class LoggerImplementation implements LogClient {
    // Map to fetch the processId in O(1), update endTime
    // Priority Queue to poll the processId in O(logN)
    private final Map<String, Process> processMap;
    private final TreeMap<Long, Process> queue;
    public LoggerImplementation() {
        this.processMap = new HashMap<>();
        this.queue = new TreeMap<>(Comparator.comparingLong(startTime -> startTime));
    }
    @Override
    public void start(String processId) {
        final Process process = new Process(processId);
        Long startTime = process.getStartTime();
        processMap.put(processId, process);
        queue.put(startTime, process);
    }

    @Override
    public void end(String processId) {
        Long endTime = System.currentTimeMillis();
        processMap.get(processId).setEndTime(endTime);
    }

    @Override
    public void poll() {
        if (queue.isEmpty()) {
            System.out.println("Empty queue...");
            return;
        }
        Process process = queue.firstEntry().getValue();
        System.out.println(process.toString());
        if (process.getEndTime() == -1) {
            System.out.println("No completed process...");
            return;
        }
        System.out.println(process.getProcessId() + " started at " + process.getStartTime()
                + " and ended at " + process.getEndTime());
        queue.pollFirstEntry();
    }
}
