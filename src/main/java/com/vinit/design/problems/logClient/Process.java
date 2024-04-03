package com.vinit.design.problems.logClient;

public class Process {
    private final String processId;
    private final Long startTime;
    private Long endTime;
    public Process(String _processId) {
        this.processId = _processId;
        this.startTime = System.currentTimeMillis();
        this.endTime = -1L;
    }
    public Long getStartTime() {return this.startTime;}
    public void setEndTime(Long _end) {this.endTime = _end;}
    public Long getEndTime() {return this.endTime;}
    public String getProcessId() {return this.processId;}
    public String toString() {
        return "P: " + this.processId + " -> " + this.startTime + ", " + this.endTime;
    }
}
