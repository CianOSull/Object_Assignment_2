package visualVM;
	
import java.io.Serializable;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;

public class Main extends Application  {
	
	private CarList listOfCars; 
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			listOfCars = new CarList();
			BorderPane mainPane = new BorderPane();
			Group root = new Group();
			Scene scene = new Scene(root,600,400);
			
			TabPane tp = new TabPane();
			
			//The this here is passing the object main into all of them so they can use the score getter and setter
			tp.getTabs().add(new CarAdd(listOfCars));
			
			mainPane.setCenter(tp);	  
			mainPane.prefHeightProperty().bind(scene.heightProperty());
			mainPane.prefWidthProperty().bind(scene.widthProperty());
		     
		    root.getChildren().add(mainPane);
			
		    primaryStage.setScene(scene);
			primaryStage.show();
		} 
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

// OLD
/*	
// Button for submit
Button b1 = new Button ("Submit Changes");

// Text Field
TextField carChanges = new TextField("");
TextField outputMessage = new TextField();
outputMessage.setPrefSize(100, 20);
outputMessage.setEditable(false);

// Drop box
ComboBox<String> dropBox = new ComboBox<String>();
dropBox.getItems().addAll("Add", "Remove", "List");

//Hbox
HBox hbox = new HBox();
	hbox.setPadding(new Insets(25, 400, 25, 25));
	hbox.setSpacing(10);
	// Background colour of hbox
	hbox.setStyle("-fx-background-color: #336699;");
	hbox.getChildren().addAll(dropBox, carChanges, b1);
	*/
