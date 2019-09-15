package application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class CarList implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Car> listCar;
	
	public CarList() {
		this.listCar = new ArrayList<Car>();
	}
	
	/**
	 * Adds a car object to he list
	 * @param c
	 */
	public void addCar(Car c) {
		listCar.add(c);
		
	}
	
	/**
	 * Removes Car object from the list
	 * @param reg
	 */
	public void removeCar(int reg) {
		Boolean noCar = true;
		for(int i = 0; i < listCar.size(); i++) {
			if(listCar.get(i).getReg() == reg) {
				listCar.remove(i);
				noCar = false;
				break;
			}
		}
		if(noCar) {
			System.out.println("\nThat car was not in the list.");
		}
		else {
			System.out.println("\nThat car was removed");
		}
	}
	
	/**
	 * Finds the car in the object in the list that is needed
	 * @param n
	 * @return
	 */
	public Car getCarInPos(int n) { return listCar.get(n);}
	
	/**
	 * Returns the amount of car objects in the list
	 * @return
	 */
	public int listSize() { return listCar.size(); }
	
	/**
	 * Sorts the list based on its natural ordering
	 */
	public void sortList() {
		Collections.sort(listCar);
	}
	
	/**
	 * Sorts list based on millage
	 */
	public void sortListByMillage() {
		Collections.sort(listCar, new CompareMillage());
	}
	
	/**
	 * Sorts list based on date
	 */
	public void sortListByDate() {
		Collections.sort(listCar, new CompareYOM());
	}
	
	/**
	 * Returns all the details of each car as one string
	 */
	public String toString(){
		String list = "The cars in the list are: ";
		for(int i = 0; i < listCar.size(); i++) {
			list += 
					"\n" + " Make: " + listCar.get(i).getMake() +
					"\n" + " Model: " + listCar.get(i).getModel() +
					"\n" + " Registration Number: " + listCar.get(i).getReg() +
					"\n" + " Millage: " + listCar.get(i).getMillage() +
					"\n" + " Year of Manufacture: " + listCar.get(i).getDOM() + 
					"\n\n Next Car:";
		}
		return list;
	}
}
