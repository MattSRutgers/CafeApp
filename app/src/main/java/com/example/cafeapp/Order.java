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

	/**
	 * The constructor for the order class.
	 * @param num the order number for this order
	 */
	Order(int num) {

		this.orderNumber = num;
	}

	/**
	 * The add method allows an order to be added
	 * @param obj the order to be added
	 * @return boolen based on adding success
	 */
	@Override
	public boolean add(Object obj) {
		if(obj != null) {
			itemList.add((MenuItem)obj);
			return true;
		}
		return false;
	}

	/**
	 * The remove method allows an order to be removed
	 * @param obj the order to be removed
	 * @return boolen based on removal success
	 */
	@Override
	public boolean remove(Object obj) {
		itemList.remove((int)obj);
		return true;
	}

	/**
	 * The to string method formats a string representing the order
	 * @return the string with the order details
	 */
	@Override
	public String toString() {
		String output = "Order Number " + this.orderNumber + ":\n";
		for(int i=0;i<itemList.size();i++) {
			output += ">" + itemList.get(i) + "\n";
		}
		output+= ">total price: " + doubleToDollar(this.getTotal());
		return output;
	}

	/**
	 * The set id method can set the id for the order
	 * @param id the id we want to set
	 */
	public void setId(int id) {
		this.orderNumber = id;
	}

	public int size() {
		return itemList.size();
	}

	public MenuItem get(int index) {
		return itemList.get(index);
	}

	/**
	 * The get total method gets the total cost of the order
	 * @return a double equal to the order's cost
	 */
	public double getTotal() {
		double sum = 0;
		for(int i=0;i<itemList.size();i++) {
			sum+=itemList.get(i).itemPrice();
		}
		return sum;
	}

	/**
	 * The double to dollar method formats a double as a string in currency format.
	 * @param value
	 * @return
	 */
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
