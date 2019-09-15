package visualVM;

import java.io.Serializable;
import java.util.Date;

public class Car implements Comparable<Car>, Serializable {
	
	private static final long serialVersionUID = 1L;
	private String make;
	private String model;
	private int registrationNumber;
	private float millage;
	private Date DOM; // Date of manufacture
	
	public Car(String mak, String mod, int reg, float mil, Date date) {
		this.make = mak;
		this.model = mod;
		this.registrationNumber = reg;
		this.millage = mil;
		this.DOM = date;
	}
	
	public void setMake(String x) {	this.make = x; }
	
	public void setModel(String x) { this.model = x; }
	
	public void setReg(int x) { this.registrationNumber = x; }
	
	public void setMillage(float x) { this.millage = x; }
	
	public void setDOM(Date x) { this.DOM = x; }
	
	public String getMake() { return make; }
	
	public String getModel() { return model; }
	
	public int getReg() { return registrationNumber; }
	
	public float getMillage() { return millage;	}
	
	public Date getDOM() { return DOM; }

	public int compareTo(Car c) {
		if(!this.getMake().equalsIgnoreCase(c.getMake())) {
			return this.getMake().compareTo(c.getMake());
		}
		else if(!this.getModel().equalsIgnoreCase(c.getModel())) {
			return this.getModel().compareTo(c.getModel());
		}
		else {
			return 0;
		}
	}
}

/*
if(!this.getMake().equalsIgnoreCase(c.getMake())) {
	return this.getMake().compareTo(c.getMake());
}
else if(!this.getModel().equalsIgnoreCase(c.getModel())) {
	return this.getModel().compareTo(c.getModel());
}
else {
	return 0;
}
*/