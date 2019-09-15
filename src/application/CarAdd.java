package application;


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
	
	/**
	 * Creates the gui for adding cars
	 * @param listOfCars
	 * @param fileManage
	 */
	public CarAdd(CarList listOfCars, FileManager fileManage) {
		  SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		  
		  setText("Add a Car");
		  GridPane  gp = new GridPane();
	      
		  // Buttons 
		  Button b1 = new Button ("Submit Car");
		  
		  //TextField
		  TextField make = new TextField("");
		  TextField model = new TextField("");
		  TextField registrationNumber = new TextField("");
		  TextField millage = new TextField("");
		  TextField yOfM = new TextField(""); // Year of Manufacture
		  
		  // Label
		  Label l1 = new Label("Make: ");
		  Label l2 = new Label("Model: ");
		  Label l3 = new Label("Registration Number: ");
		  Label l4 = new Label("Millege: ");
		  Label l5 = new Label("Year of Manufacture (Format is 12-sep-2018: ");
		  
		  VBox vboxText = new VBox();
		  vboxText.setPadding(new Insets(30, 25, 25, 10));
		  vboxText.setSpacing(27);
	      vboxText.getChildren().addAll(make, model, registrationNumber, millage, yOfM, b1);
	      
	      VBox vboxLabel = new VBox();
	      vboxLabel.setPadding(new Insets(10, 5, 25, 10));
	      vboxLabel.setSpacing(35);
	      vboxLabel.getChildren().addAll(l1, l2, l3, l4, l5);
	      
	      b1.setOnAction(e->{
		    	  if(isDate(yOfM.getText())) {
		    		if(isFloat(millage.getText())) {
		    			if(make.getText() != null || model.getText() != null || registrationNumber.getText() != null || 
		    					millage.getText() != null || yOfM.getText() != null) {
		    				try {
								Car newCar = new Car(make.getText(), model.getText(), Integer.parseInt(registrationNumber.getText()), 
								Float.valueOf(millage.getText()), formatter.parse(yOfM.getText()));
								listOfCars.addCar(newCar);
								fileManage.WriteObjectToFile(listOfCars);
								System.out.print("The car was added");
							}  
		    				catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
			    	  	}
		    			else {
		    				System.out.println("You have not filled all the fields!");
		    			}
		    		}
		    		else {
		    			System.out.println("Thats not a float");
		    		}
		    	  }
		    	  else {
		    		  System.out.println("Thats not a date");
		    	  }
	    	  });
	      
	      //Add all the elements
	      gp.add(vboxLabel, 0, 0);
		  gp.add(vboxText, 0, 0);
	      
	      setContent(gp);
	}
	
	public Boolean isDate(String string) {
		try {
			formatter.parse(string);
			return true;
		}
		catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("You did not enter the date in right, the format is e.g. 01-jun-2019");
		}
		return false;
	}
	
	public Boolean isFloat(String string) {
		try {
			Float.parseFloat(string);
			return true;
		}
		catch(NumberFormatException e){
			System.out.println("You didnt input a number!");
		}
		return false;
	}
}
