package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileManager implements Serializable {
	
	private String filepath="carListFile.txt"; // File is not bieng found, find a fix
	private CarList listOfCars;
	private static final long serialVersionUID = 1L;
	
	public FileManager() {
		this.listOfCars = new CarList();
	}
	
	/**
	 * Writes a list of cars objects to a file to store the data.
	 * @param lfc
	 */
	public void WriteObjectToFile(CarList lfc) {
        try {
        	this.listOfCars = lfc;
        	
        	/*
        	 * Maybe instead just do a for loop that puts all the individual cars from the list into the file and then just use arraylist add all
        	 * to rebuild the list
        	 */
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(listOfCars);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");
        } 
        
        catch (FileNotFoundException e) {
        	System.out.println("File not found");
        	System.out.println(e);
        	//e.printStackTrace();
		} 
        
        catch (IOException e) {
			System.out.println("Error initializing stream");
        	System.out.println(e);
			//e.printStackTrace();
		}
    }
	
	/**
	 * Reasd a list of cars object from a text file to store information
	 * @return
	 */
	public CarList readObjectFromFile() {
        try {
        	
        	// Might need the file so: FileInputStream fi = new FileInputStream(new File("myObjects.txt"));
        	
        	FileInputStream fi = new FileInputStream(filepath);
			ObjectInputStream oi = new ObjectInputStream(fi);
        	
			this.listOfCars = (CarList) oi.readObject();

			System.out.println("CarList Successfully inputted");

			oi.close();
			fi.close();
 
        } 
        
        catch (FileNotFoundException e) {
        	System.out.println("File not found");
        	System.out.println(e);
        	//e.printStackTrace();
		} 
        
        catch (IOException e) {
			System.out.println("Error initializing stream");
        	System.out.println(e);
			//e.printStackTrace();
			
		} 
        
        catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
        	System.out.println(e);
		}
        
        return listOfCars;
    }
	
}
