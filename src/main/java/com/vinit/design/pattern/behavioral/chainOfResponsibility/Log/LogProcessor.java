package com.vinit.design.pattern.behavioral.chainOfResponsibility.Log;

import com.vinit.design.pattern.behavioral.chainOfResponsibility.enums.LogLevel;

public interface LogProcessor {
    public void log(LogLevel level, String message);
    default void show() {
        System.out.println("Ok Show");
    }
}
