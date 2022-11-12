package com.example.myapplication.model;

public class CollectedGarbage {

    private String startDate;
    private String endDate;
    private int size;
    private int id;

    public CollectedGarbage() {
    }

    public String getStartDate() {
        return startDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
