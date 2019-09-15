package carJarTest;
import java.util.Date;

import application.CarBasic;

public class RealCar extends CarBasic{

	// Forgot to remove the serial tag from CarBasic so I just put this here to remove a warning
	private static final long serialVersionUID = 1L;
	private float millage;
	
	public RealCar(String mak, String mod, int reg, float mil, Date date) {
		super(mak, mod, reg, date);
		// TODO Auto-generated constructor stub
		this.millage = mil;
	}
	
	public float getMillage(){ return millage; }
	
	public void setMillage(float num) { this.millage = num;}
	
	public String toString(){
		String list = "The cars in the list are: \n" + " Make: " + this.getMake() +
					"\n" + " Model: " + this.getModel() +
					"\n" + " Registration Number: " + this.getReg() +
					"\n" + " Millage: " + this.getMillage() +
					"\n" + " Year of Manufacture: " + this.getDOM();
		return list;
	}
}
