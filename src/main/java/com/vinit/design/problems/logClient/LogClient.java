package com.vinit.design.problems.logClient;

public interface LogClient {
    void start(String processId);
    void end(String processId);
    void poll();

}
