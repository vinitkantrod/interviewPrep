package com.vinit.design.problems.logClient;

public class LoggerMain {

    public static void main(String[] args) {
        // 1 -> 10, 15
        // 2 -> 8, 12
        // 3 -> 7, -1
        LoggerImplementation lg = new LoggerImplementation();
        lg.start("3");
        lg.poll();
        lg.start("2");
        lg.poll();
        lg.start("1");
        lg.poll();
        lg.end("2");
        lg.poll();
        lg.end("3");
        lg.poll();
        lg.end("1");
        lg.poll();
        lg.poll();
        lg.poll();
    }
}
