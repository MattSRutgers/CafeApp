/**
 * 
 */
package com.example.cafeapp;

import java.io.Serializable;

/**
 * @author Matthew Schilling and Gordon Miller
 *
 */
public class Donut extends MenuItem implements Customizable, Serializable {
	private String type;
	private String flavor;
	//private double cost = 0.0;
	private final static String DONUT = "Donut";
	private final double YEASTPRICE = 1.39;
	private final double CAKEPRICE = 1.59;
	private final double MINIPRICE = 0.33;


	/**
	 * The donut constructor
	 * @param flavor the flavor of the donut
	 * @param type the type of the donut
	 * @param cost the cost of the donut
	 */
	Donut(String flavor, String type, double cost) {
		//cost = this.itemPrice();
		super(DONUT, cost);
		this.type = type;
		this.flavor = flavor;
	}

	@Override
	public boolean add(Object obj) {
		return false;
	}

	@Override
	public boolean remove(Object obj) {
		return false;
	}
	/**
	 * The to string method returns a string representation of the donut
	 */
	@Override
	public String toString() {
		String donutDetails = flavor + " " +type + " " + DONUT + " | $" + doubleToDollar(this.itemPrice()) ;
		return donutDetails;
	}
	/**
	 * this method returns the price of the donut
	 */
	@Override
	public double itemPrice() {
		double findPrice = 0;
		if(type.equalsIgnoreCase("Yeast"))
			findPrice = YEASTPRICE;
		if(type.equalsIgnoreCase("Cake"))
			findPrice = CAKEPRICE;
		if(type.equalsIgnoreCase("Mini Donut"))
			findPrice = MINIPRICE;
		return findPrice;
	}

}
