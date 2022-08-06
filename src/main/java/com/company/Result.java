package com.company;

import java.util.ArrayList;

public class Result<T> {
    private T data;
    private boolean error;
    private ArrayList<String> alerts;


    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public ArrayList<String> getAlerts() {
        return alerts;
    }

    public void setAlerts(ArrayList<String> alerts) {
        this.alerts = alerts;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
