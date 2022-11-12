package com.example.myapplication.model;

public class Panel {
    private float height;
    private float width;
    private static double ratePerM2 = 10000;

     public Panel(){

    }

    public Panel(float height, float width) {
        this.height = height;
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }


    public double panelCost(float height,float width){
         return height * width * ratePerM2;
    }
}
