
public class Car {
	private String make; 
	private String model;
	private int year;
	private int price;
	private static int nbCarsCreated = 0;

	/** 
	 * Default constructor for Car class 
	 */
	public Car() {
		this.make = "";
		this.model = "";
		this.year = 0;
		this.price = 0;
		nbCarsCreated += 1;
	}
	
	/**
	 * Parametrized constructor for Car class
	 * @param theMake The make of the car. 
	 * @param theModel The model of the car.
	 * @param theYear The year the car was manufactured. 
	 * @param thePrice The price of the car. 
	 */
	public Car(String theMake, String theModel, int theYear, int thePrice) {
		this.make = theMake;
		this.model = theModel;
		this.year = theYear;
		this.price = thePrice;
		
		nbCarsCreated += 1;
	}
	
	/**
	 * Copy constructor for Car class
	 * @param car2 Another Car to be copied. 
	 */
	public Car(Car car2) {
		this.make = car2.make;
		this.model = car2.model;
		this.year = car2.year;
		this.price = car2.price;
		nbCarsCreated += 1;
	}
	
	/** 
	 * @return this Car's make.
	 */
	public String getMake() {
		return(this.make);
	}
	
	/**
	 * @return this Car's model.
	 */
	public String getModel() {
		return(this.model);
	}
	
	/**
	 * @return this Car's year.
	 */
	public int getYear() {
		return(this.year);
	}
	
	/** 
	 * @return this Car's price.
	 */
	public double getPrice() {
		return(this.price);
	}

	/**
	 * Sets the Car's make
	 * @param theMake this Car's make
	 */
	public void setMake(String theMake) {
		this.make = theMake;
	}
	
	/**
	 * Sets the Car's model
	 * @param theModel this Car's model
	 */
	public void setModel(String theModel) {
		this.model = theModel;
	}
	
	/**
	 * Sets the Car's year
	 * @param theYear this Car's year
	 */
	public void setYear(int theYear) {
		this.year = theYear;
	}
	
	/** 
	 * Sets the Car's price
	 * @param thePrice this Car's Price
	 */
	public void setPrice(int thePrice) {
		this.price = thePrice;
	}
	
	/**
	 * Gives all information about a car 
	 * @return Make, model, year, and price of this car. 
	 */
	public String toString() {
		return("Make: " + this.make + '\n' + "Model: " + this.model + '\n'  + "Year: " + this.year + '\n'  + "Price: " + this.price);
	}
	
	/**
	 * Checks equality of this car with another Car. Equal if have same make and model.
	 * @param car2 The Car to be compared with.
	 * @return boolean for equality of the two Cars.
	 */
	public boolean equals(Car car2) {
		return(this.make == car2.make && this.model == car2.model);
	}
	
	/**
	 * Gives the number of Car objects that have been created (at the time this method is called). 
	 * @return Number of Car objects created (at the time this method is called)
	 */
	public static int findNumberOfCreatedCars(){ 
		return (nbCarsCreated);
	}

}
