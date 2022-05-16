package com.example.ws;

import java.io.Serializable;

public class testValute implements Serializable {
    private int valuteNumCode;
    private String  valuteCharCode;
    private String valuteName;
    private double valuteValue;

    public testValute(int valuteNumCode, String valuteCharCode, String valuteName, double valuteValue){
        this.valuteNumCode = valuteNumCode;
        this.valuteCharCode = valuteCharCode;
        this.valuteName = valuteName;
        this.valuteValue = valuteValue;
    }

    public int getValuteNumCode() {
        return valuteNumCode;
    }

    public void setValuteNumCode(int valuteNumCode) {
        this.valuteNumCode = valuteNumCode;
    }

    public String getValuteCharCode() {
        return valuteCharCode;
    }

    public void setValuteCharCode(String valuteCharCode) {
        this.valuteCharCode = valuteCharCode;
    }

    public String getValuteName() {
        return valuteName;
    }

    public void setValuteName(String valuteName) {
        this.valuteName = valuteName;
    }

    public double getValuteValue() {
        return valuteValue;
    }

    public void setValuteValue(double valuteValue) {
        this.valuteValue = valuteValue;
    }
}
