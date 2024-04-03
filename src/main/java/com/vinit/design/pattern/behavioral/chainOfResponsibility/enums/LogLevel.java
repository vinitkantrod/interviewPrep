package com.vinit.design.pattern.behavioral.chainOfResponsibility.enums;

public enum LogLevel {
    DEBUG(1),
    TRACE(2),
    INFO(3),
    WARNING(4),
    ERROR(5);

    final int level;

    LogLevel(int level) {
        this.level = level;
    }
    public int getLevel() {return level;}
}
