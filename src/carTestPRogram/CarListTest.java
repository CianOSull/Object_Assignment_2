/**
 * 
 */
package carTestPRogram;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;

import application.CarList;
import application.Car;

/**
 * @author Cian
 *
 */
public class CarListTest {
	
	CarList listOfCars;
	private SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
	
	/*
	 * How all these test is taht each test is independant of the otehr so we have to rebuild the list each time
	 */
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		listOfCars = new CarList();
		try {
			Car c1 = new Car("C", "3", 6, 1, formatter.parse("12-Jun-2020"));
			Car c2 = new Car("B", "85", 3, 1, formatter.parse("12-Jun-2020"));
			Car c3 = new Car("A", "20", 7, 1, formatter.parse("12-Jun-2020"));
			Car c4 = new Car("A", "1", 5, 0, formatter.parse("12-Jun-2019"));
			listOfCars.addCar(c1);
			listOfCars.addCar(c2);
			listOfCars.addCar(c3);
			listOfCars.addCar(c4);;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link application.CarList#addCar(application.Car)}.
	 */
	@Test
	public void testAddCar() {
		try {
			int oldSize = listOfCars.listSize();
			
			Car c5 = new Car("Z", "65", 9, 0, formatter.parse("12-Jun-2019"));
			listOfCars.addCar(c5);
			assertTrue(oldSize < listOfCars.listSize());
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link application.CarList#removeCar(int)}.
	 */
	@Test
	public void testRemoveCar() {
		int oldSize = listOfCars.listSize();
		
		listOfCars.removeCar(6);
		assertTrue(listOfCars.listSize() < oldSize);
	}

	/**
	 * Test method for {@link application.CarList#sortList()}.
	 */
	@Test
	public void testSortList() {
		CarList unsortedList = listOfCars;
		listOfCars.sortList();
		CarList sortedList = listOfCars;
		// If the millages are the same then the lists are not sorted
		assertTrue(unsortedList.getCarInPos(0).getReg() == sortedList.getCarInPos(0).getReg());
		
	}

	/**
	 * Test method for {@link application.CarList#toString()}.
	 */
	@Test
	public void testToString() {
		assertTrue(String.class.isInstance(listOfCars.toString()));
	}

}
