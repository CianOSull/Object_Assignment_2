package application;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class CarListMessage extends Tab {
	
	CompareMillage millageCompare;
	
	/**
	 * This class outputs the details of the cars in the list to the screen and console and sorts the lists.
	 * @param listOfCars
	 */
	public CarListMessage(CarList listOfCars) {
		setText("List the Cars");
		
		millageCompare = new CompareMillage();
		
		Button b1 = new Button ("List Cars (All lists will be output to the console)");
		Button b2 = new Button ("Sort by Make and Model");
		Button b3 = new Button ("Sort by Year of Manufacture");
		Button b4 = new Button ("Sort by Millage");
		
		TextArea output = new TextArea("");
		output.setEditable(false);
		output.setPrefSize(100, 100);
		Label l1 = new Label("List of all the Cars");
		String splitUp = "\n======================================New List================================\n";
		
		VBox vbox = new VBox();
	    vbox.setPadding(new Insets(10, 5, 25, 10));
	    vbox.setSpacing(10);
	    //Background colour
	    vbox.setStyle("-fx-background-color: orange;");
	    //Font colour
	    vbox.getChildren().addAll(l1, output, b1, b2, b3, b4);
	    
	    b1.setOnAction(e->{
	    	System.out.print(splitUp + listOfCars.toString());
	    	output.setText(listOfCars.toString());
	    });
	    b2.setOnAction(e->{
	    	// This collection should sort using the natural ording
	    	listOfCars.sortList();
	    	System.out.print(splitUp + listOfCars.toString());
	    	output.setText(listOfCars.toString());
	    });
	    b3.setOnAction(e->{
	    	// Sort using year of manufacture
	    	listOfCars.sortListByDate();
	    	System.out.print(splitUp + listOfCars.toString());
	    	output.setText(listOfCars.toString());
	    });
	    b4.setOnAction(e->{
	    	// Sort using millage
	    	listOfCars.sortListByMillage();
	    	System.out.print(splitUp + listOfCars.toString());
	    	output.setText(listOfCars.toString());
	    });
	    
	    setContent(vbox);
	}
}
