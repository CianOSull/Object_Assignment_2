package application;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class CarRemove extends Tab {
	
	/**
	 * Is the gui for removing a car.
	 * @param listOfCars
	 * @param fileManage
	 */
	public CarRemove(CarList listOfCars, FileManager fileManage) {
		
		setText("Remove a Car");
		
		Button b1 = new Button ("Remove Car");
		
		TextField removeCar = new TextField("");
		Label l1 = new Label("Enter the registration number to remove that car");
		
		VBox vbox = new VBox();
	    vbox.setPadding(new Insets(10, 5, 25, 10));
	    vbox.setSpacing(10);
	    //Background colour
	    vbox.setStyle("-fx-background-color: green;");
	    //Font colour
	    vbox.getChildren().addAll(l1, removeCar, b1);
	    
	    b1.setOnAction(e->{
	    	listOfCars.removeCar(Integer.parseInt(removeCar.getText()));
	    	fileManage.WriteObjectToFile(listOfCars);
	    	System.out.println("That car was removed.");
	    });
	    
	    setContent(vbox);
	}
}
