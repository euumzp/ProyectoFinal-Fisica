package com.labfisica.xydata;

public class XYData {
    public double[] x;
    public double[] y;
    public String xName;
    public String yName;
    
    public XYData(double[] x, double[] y, String xName, String yName) {
        this.x = x;
        this.y = y;
        this.xName = xName;
        this.yName = yName;
    }
}