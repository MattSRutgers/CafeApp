/**
 * 
 */
package com.example.cafeapp;

import java.io.Serializable;

/**
 * @author Matthew Schilling and Gordon Miller
 *
 */
public class Coffee extends MenuItem implements Customizable, Serializable {
	private String size;
	private String addIns;
	private final static String[] ADDIN_NAMES = {"Cream", "Syrup", "Milk", "Caramel", "Whipped Cream"};
	private int[] addInAmounts = new int[5];
	private int numAddIns = 0;
	private double cost = 0.0;
	private final static String COFFEE = "Coffee";
	private final static double ADDINCOST = 0.20;
	private final static int NOT_FOUND = -1;
	private final static double SHORTCOST = 1.99;
	private final static double TALLCOST = 2.49;
	private final static double GRANDECOST = 2.99;
	private final static double VENTICOST = 3.49;


	/**
	 * The coffee constructor creates menu items that represent different cups of coffee
	 * @param size the coffee cup size

	 */
	Coffee(String size, int numAddIns, String addIns) {
		//cost = this.itemPrice();
		super(COFFEE);
		this.size = size;
//		this.addInAmounts[0] = numCream;
//		this.addInAmounts[1] = numSyrup;
//		this.addInAmounts[2] = numMilk;
//		this.addInAmounts[3] = numCaramel;
//		this.addInAmounts[4] = numWhippedCream;
		this.numAddIns = numAddIns;
		this.addIns = addIns;
		
	}

	/**
	 * The add method will add addins
	 */
	@Override
	public boolean add(Object obj) {
		String addInType = (String)obj;
		int index = findAddInIndex(addInType, ADDIN_NAMES);
		if(index != -1) {
			addInAmounts[index]++;
			this.numAddIns++;
			return true;
		}
		return false;
	}

	/**
	 * The remove method will remove addins
	 */
	@Override
	public boolean remove(Object obj) {
		String addInType = (String)obj;
		int index = findAddInIndex(addInType, ADDIN_NAMES);
		if(index != -1 && addInAmounts[index]>0) {
			addInAmounts[index]--;
			this.numAddIns--;
			return true;
		}
		return false;
	}
	/**
	 * The to string method returns a string representation of the coffee
	 */
	@Override
	public String toString() {
		String coffeeDetails = size + " " + COFFEE + " | " + addIns;
//		for(int i=0;i<5;i++){
//			if(addInAmounts[i]>0) {
//				if(i!=0)
//					coffeeDetails += ", ";
//				coffeeDetails += + addInAmounts[i] + "x " + ADDIN_NAMES[i];
//			}
//		}
		coffeeDetails+= " | $" + doubleToDollar(this.itemPrice());
		return coffeeDetails;
	}
	/**
	 * The itemPrice method returns the price of the cofee
	 */
	@Override
	public double itemPrice() {
		double findPrice = sizePrice(this.size) + (ADDINCOST * numAddIns);
		return findPrice;
	}
	/**
	 * This method will sum an array
	 * @param array the array to sum
	 * @return the sum found
	 */
	private static int sum(int[] array) {
		int sum = 0;
		for(int i = 0; i< array.length; i++)
		{
			sum += array[i];
		}
		return sum;
	}
	/**
	 * This method determines the price
	 * @param size of the coffee
	 * @return the price
	 */
	private static double sizePrice(String size) {
		if(size.equals("Short")) {
			return SHORTCOST;
		}
		else if(size.equals("Tall")) {
			return TALLCOST;
		}
		else if(size.equals("Grande")) {
			return GRANDECOST;
		}
		else {
			return VENTICOST;
		}
	}
	/**
	 * this mehod finds the index of the addin to change
	 * @param type the type of addin
	 * @param names their names
	 * @return the index of the item, or -1 if not found
	 */
	private static int findAddInIndex(String type, String[] names) {
		for(int i=0; i<names.length; i++) 
			if(type.equals(names[i]))
				return i;
		
		return NOT_FOUND;
	}

}
