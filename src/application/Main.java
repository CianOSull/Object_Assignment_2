package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;

public class Main extends Application  {
	
	private CarList listOfCars; 
	private FileManager carListFile;
	
	@Override
	public void start(Stage primaryStage) {
		
		// This file manager puts the car list object into a file and also allows you to put the contents into a new calss at the start
		carListFile = new FileManager();
		listOfCars = carListFile.readObjectFromFile();
		
		try {
			BorderPane mainPane = new BorderPane();
			Group root = new Group();
			Scene scene = new Scene(root,600,400);
			
			TabPane tp = new TabPane();
			
			//The this here is passing the object main into all of them so they can use the score getter and setter
			tp.getTabs().add(new CarAdd(listOfCars, carListFile));
			tp.getTabs().add(new CarRemove(listOfCars, carListFile));
			tp.getTabs().add(new CarListMessage(listOfCars));
			
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