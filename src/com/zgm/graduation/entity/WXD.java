package com.zgm.graduation.entity;

public class WXD {
    private int id;
    private double Midfrequency;
    private double Bandwidth;
    private double Scope;
    private double Carriernoise;
    private String time;
    
    
    public WXD(int id, double midfrequency, double bandwidth, double scope, double carriernoise, String time) {
		
		this.id = id;
		Midfrequency = midfrequency;
		Bandwidth = bandwidth;
		Scope = scope;
		Carriernoise = carriernoise;
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getMidfrequency() {
		return Midfrequency;
	}
	public void setMidfrequency(double midfrequency) {
		Midfrequency = midfrequency;
	}
	public double getBandwidth() {
		return Bandwidth;
	}
	public void setBandwidth(double bandwidth) {
		Bandwidth = bandwidth;
	}
	public double getScope() {
		return Scope;
	}
	public void setScope(double scope) {
		Scope = scope;
	}
	public double getCarriernoise() {
		return Carriernoise;
	}
	public void setCarriernoise(double carriernoise) {
		Carriernoise = carriernoise;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	}
