package application;

import java.util.Comparator;

public class CompareMillage implements Comparator<Car> {
	
	/**
	 * Is the comparator for millage
	 */
	@Override
	public int compare(Car c1, Car c2) {
		// TODO Auto-generated method stub
		//return c2.getMillage() - c1.getMillage();
		return (int) (c1.getMillage() - c2.getMillage());
	}
}
