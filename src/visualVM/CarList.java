package visualVM;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class CarList implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Car> listCar;
	
	public CarList() {
		this.listCar = new ArrayList<Car>();
	}
	
	public void addCar(Car c) {
		listCar.add(c);
		
	}
	
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
	
	public void sortList() {
		Collections.sort(listCar);
	}
	
	public String toString(){
		String list = "The cars in the list are: ";
		for(int i = 0; i < listCar.size(); i++) {
			list += 
					"\n" + " Make: " + listCar.get(i).getMake() +
					"\n" + " Model: " + listCar.get(i).getModel() +
					"\n" + " Registration Number: " + listCar.get(i).getReg() +
					"\n" + " Millage: " + listCar.get(i).getMillage() +
					"\n" + " Year of Manufacture: " + listCar.get(i).getDOM();
		}
		return list;
	}
	
}
