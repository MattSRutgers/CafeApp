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
	private String flavor;
	private final static String DONUT = "Donut";
	private final double PRICE = 1.39;



	/**
	 * The donut constructor
	 * @param flavor the flavor of the donut
	 */
	Donut(String flavor) {
		super(DONUT);
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
		String donutDetails = flavor +  DONUT + " | $" + PRICE ;
		return donutDetails;
	}
	/**
	 * this method returns the price of the donut
	 */
	@Override
	public double itemPrice() {
		return PRICE;
	}

}
