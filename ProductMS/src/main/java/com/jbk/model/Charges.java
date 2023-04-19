package com.jbk.model;

public class Charges {
private int gst;
private double deliveryCharge;

public Charges() {
	// TODO Auto-generated constructor stub
}

public Charges(int gst, double deliveryCharge) {
	super();
	this.gst = gst;
	this.deliveryCharge = deliveryCharge;
}

public int getGst() {
	return gst;
}

public void setGst(int gst) {
	this.gst = gst;
}

public double getDeliveryCharge() {
	return deliveryCharge;
}

public void setDeliveryCharge(double deliveryCharge) {
	this.deliveryCharge = deliveryCharge;
}

@Override
public String toString() {
	return "Charges [gst=" + gst + ", deliveryCharge=" + deliveryCharge + "]";
}



}
