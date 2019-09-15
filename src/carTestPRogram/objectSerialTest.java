package carTestPRogram;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;

import application.Car;
import application.CarList;
import application.FileManager;

public class objectSerialTest {
	
	CarList listOfCars;
	FileManager manageFile;
	private SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
	
	@Before
	public void setUp() throws Exception {
		listOfCars = new CarList();
		manageFile = new FileManager();
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

	@Test
	public void testWriteObjectToFile() {
		manageFile.WriteObjectToFile(listOfCars);
		CarList newCarList = manageFile.readObjectFromFile();
		assertNotSame(listOfCars, newCarList);
	}

	@Test
	public void testReadObjectFromFile() {
		manageFile.WriteObjectToFile(listOfCars);
		CarList newCarList = manageFile.readObjectFromFile();
		assertNotSame(listOfCars, newCarList);
	}

}
