package com.vinit.design.pattern.builder;

public class CarMain {

    public static void main(String[] args) {
        CarBuilder carBuilder = new CarBuilder();
        Director carD = new Director();
        carD.manufactureCar(carBuilder);
        Car car = carBuilder.getProduct();
        ManualBuilder manualBuilder = new ManualBuilder();
        Director manualD = new Director();
        manualD.generateManual(manualBuilder);
        Manual manual = manualBuilder.getProduct();
        System.out.println(car.toString());
        System.out.println(manual.toString());
    }
}
