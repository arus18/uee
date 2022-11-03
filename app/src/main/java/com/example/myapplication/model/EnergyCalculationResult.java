package com.example.myapplication.model;

public class EnergyCalculationResult {

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    private String group;
    private String type;
    private int quantity;
    private String result;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EnergyCalculationResult(String group, String type, int quantity, String result) {
        this.group = group;
        this.type = type;
        this.quantity = quantity;
        this.result = result;
    }

    public EnergyCalculationResult() {
    }
}
