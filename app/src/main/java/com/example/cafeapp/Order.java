/**
 *
 */
package com.example.cafeapp;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * @author Matthew Schilling and Gordon Miller
 * The order class keeps a list of the menu items the user adds and generates a unique order number
 *
 */
public class Order implements Customizable, Serializable {

	private ArrayList<MenuItem> itemList = new ArrayList<MenuItem>();

	private int orderNumber;


	Order(int num) {
		this.orderNumber = num;
	}

	@Override
	public boolean add(Object obj) {
		if(obj != null) {
			itemList.add((MenuItem)obj);
			return true;
		}
		return false;
	}

	@Override
	public boolean remove(Object obj) {
		itemList.remove((int)obj);
		return true;
	}

	@Override
	public String toString() {
		String output = "Order Number " + this.orderNumber + ":\n";
		for(int i=0;i<itemList.size();i++) {
			output += ">" + itemList.get(i) + "\n";
		}
		output+= ">total price: " + doubleToDollar(this.getTotal());
		return output;
	}

	public void setId(int id) {
		this.orderNumber = id;
	}

	public int size() {
		return itemList.size();
	}

	public MenuItem get(int index) {
		return itemList.get(index);
	}

	public double getTotal() {
		double sum = 0;
		for(int i=0;i<itemList.size();i++) {
			sum+=itemList.get(i).itemPrice();
		}
		return sum;
	}

	private static String doubleToDollar(double value) {
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
