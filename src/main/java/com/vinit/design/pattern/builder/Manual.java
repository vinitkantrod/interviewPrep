package com.vinit.design.pattern.builder;

public class Manual {

    String seat;
    String headlight;
    String headlightType;
    String rooftop;
    String tyreSize;
    String engineType;
    public Manual() {}

    public String toString() {
        return "-------------------------------\n                 Manual                 \n-----------------------------" +
                "\n" + seat + ".\n" + headlight + "." +
                "\n" + headlightType + "\n" + tyreSize + "." +
                "\n" + engineType + ".\n--------------------";
    }
}
