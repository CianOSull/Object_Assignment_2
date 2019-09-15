package visualVM;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CarAdd extends Tab {
	
	private SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
	
	public CarAdd(CarList listOfCars) {
		  SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		  
		  setText("Add a Car");
		  GridPane  gp = new GridPane();
	      
		  // Buttons 
		  Button b1 = new Button ("Waste lots of memory");
		  Button b2 = new Button ("Break the system");
		  
	      b1.setOnAction(e->{
	    	  System.out.print("Button 1 was pressed, please wait");
	    	  try {
				for(int i = 0; i < 100; i++) {
					Car newCar = new Car("a", "b", 5, 0, formatter.parse("12-Jun-2019"));
					listOfCars.addCar(newCar);
					System.out.print("The car was added");
				}
			}  
			catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	  System.out.print("Button 1 was pressed and is now finished");
	      });
	      
	      b2.setOnAction(e->{
	    	  System.out.print("Out Of memory begins now");
				try {
					while(true){
						Car newCar = new Car("a", "b", 5, 0, formatter.parse("12-Jun-2019"));
						listOfCars.addCar(newCar);
						listOfCars.addCar(newCar);
						listOfCars.addCar(newCar);
						listOfCars.addCar(newCar);
						listOfCars.addCar(newCar);
						listOfCars.addCar(newCar);
						listOfCars.addCar(newCar);
						listOfCars.addCar(newCar);
						listOfCars.addCar(newCar);
						listOfCars.addCar(newCar);
						listOfCars.addCar(newCar);
						listOfCars.addCar(newCar);
						listOfCars.addCar(newCar);
						listOfCars.addCar(newCar);
						listOfCars.addCar(newCar);
						listOfCars.addCar(newCar);
						listOfCars.addCar(newCar);	
						System.out.print("The car was added");
					}
				}  
				catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		   });
	      
	      // Set the background
	      //gp.setStyle("-fx-background-color: yellow");
	      
	      //Add all the elements
	      gp.add(b1, 0, 0);
	      gp.add(b2, 20, 0);
	      
	      setContent(gp);
	}
}