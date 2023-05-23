package com.vinit.design.pattern.builder;

public interface Builder {

    public void setSeats(int _seats);
    public void setHeadlight(int _count, String _type);
    public void setRooftop(Boolean _isRooftop);
    public void setTyreSize(int _size);
    public void setEngine(String _engine);

}
