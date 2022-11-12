package com.example.myapplication.model;

public class SolarEnergyResult {


    private String Sname;

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        this.Sname = sname;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public float getUnits() {
        return units;
    }

    public void setUnits(float units) {
        this.units = units;
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public float getOutput() {
        return output;
    }

    public void setOutput(float output) {
        this.output = output;
    }

    private float area;
    private float units;
    private float income;
    private float output;

    public void setResult(String result) {
        this.result = result;
    }

    private String result;

    public SolarEnergyResult(String sname, float area, float units, float income, float output,String result) {
        Sname = sname;
        this.area = area;
        this.units = units;
        this.income = income;
        this.output = output;
        this.result=result;
    }
    public SolarEnergyResult() {
    }
    public String getResult() {
        return result;
    }
}
