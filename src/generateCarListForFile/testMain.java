package generateCarListForFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import application.Car;
import application.CarList;

public class testMain {
	
	static SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CarList listOfCars = new CarList();
		
		try {
			Car car1 = new Car("s", "s", 5, 0, formatter.parse("12-jun-2019"));
			Car car2 = new Car("r", "r", 6, 0, formatter.parse("12-jun-2019"));
			Car car3 = new Car("t", "t", 4, 0, formatter.parse("12-jun-2019"));
			Car car4 = new Car("u", "u", 3, 0, formatter.parse("12-jun-2019"));
			listOfCars.addCar(car1);
			listOfCars.addCar(car2);
			listOfCars.addCar(car3);
			listOfCars.addCar(car4);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dummySerial newDummy = new dummySerial();
		newDummy.WriteObjectToFile(listOfCars);
	}

}
