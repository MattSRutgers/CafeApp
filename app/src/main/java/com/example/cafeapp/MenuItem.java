package com.example.cafeapp;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 * @author Matthew Schilling and Gordon Miller
 * the menu item class is the superclass for everything a user can order
 *
 */
public class MenuItem implements Serializable {
	private String description;
	private double cost;
	
	MenuItem(String description){
		this.description = description;
		//this.cost = cost;
	}
	
	/**
	 * The itemPrice method will be overridden by the coffee and donut subclasses
	 */
	public double itemPrice() {
		return cost;
	}
	/**
	 * The toString method will return a string of the name and the cost, and be overridden by the subclasses
	 */
	@Override
	public String toString() {
		String itemInfo = new String(description + " $" + Double.toString(cost));
		return itemInfo;
	}
	/**
	 * This method will convert a double value into a formatted string
	 * @param value the double to format
	 * @return the formatted value
	 */
	protected static String doubleToDollar(double value) {
		if(value == 0) {
			return "0.00";
		}
		DecimalFormat dollarFormatter = new DecimalFormat("#.00");
    	dollarFormatter.setGroupingUsed(true);
    	dollarFormatter.setGroupingSize(3);
    	String valueStr = dollarFormatter.format(value);
    	return valueStr;
	}

}
