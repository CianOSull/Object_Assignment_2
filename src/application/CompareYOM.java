package application;

import java.util.Comparator;

public class CompareYOM implements Comparator<Car> {

	/**
	 * Is the comparator for year of manufacrue
	 */
	@Override
	public int compare(Car o1, Car o2) {
		// TODO Auto-generated method stub
		// Havent tested this yet, might be able just to do return o1.getDom.compareTo(o2.getDom)
		if(o1.getDOM().equals(o2.getDOM())) {
			return o1.getDOM().compareTo(o2.getDOM());
		}
		else {
			return 0;
		}
	}
}
