import java.util.Scanner;

public class CarDealership extends Car {

	// Declaring variables
	public static int maxNbCars, userChoice, enterCars, lastIndex;
	public static int nbAttempts, totalAttempts = 0;
	protected int minPrice, maxPrice; 
	public static final String PASSWORD = "comp249S19";
	public static int i;
	
	public static Scanner keyIn = new Scanner(System.in);   	
	public static String enteredPW, theMake, theModel; 
	public static int carNb, thePrice, theYear;
	public static int option2Choice; 

	public static Car[] carDatabase; 
	
	public static void option1() {
		// Asking for password 
		System.out.print("Please enter the password: ");
		enteredPW = keyIn.next();
		nbAttempts = 1;
		totalAttempts += 1; 
		
		// If password is incorrect, ask for another password (max of 3 attempts)
		while(!PASSWORD.equals(enteredPW) && nbAttempts < 3) {	
			System.out.println("Wrong password. Please try again.");
			enteredPW = keyIn.next();
			nbAttempts += 1;
			totalAttempts += 1; 	
		}
		
		if (PASSWORD.equals(enteredPW)) {
			// If password is correct, proceed as usual 
			totalAttempts -= 1; // removing 1 attempt from total since password was correct 
			System.out.println('\n' + "Password accepted");
			System.out.print("How many cars will you like to enter? ");
			enterCars = keyIn.nextInt();
			lastIndex = enterCars + Car.findNumberOfCreatedCars();
			
			if (enterCars > (maxNbCars - Car.findNumberOfCreatedCars())) {
				System.out.println("Not enough space to add all the cars. Only able to add " + (maxNbCars - Car.findNumberOfCreatedCars()) + " cars" + '\n');
				lastIndex = maxNbCars;
			}
			
			// Entering info for each car 
			while (Car.findNumberOfCreatedCars() < lastIndex) {
				i = Car.findNumberOfCreatedCars();
				// User prompt for information about car i
				System.out.println("Enter info for car " + i + ":");
				System.out.print("Make: ");
				theMake = keyIn.next();
				System.out.print("Model: ");
				theModel = keyIn.next();
				System.out.print("Year: ");
				theYear = keyIn.nextInt();
				System.out.print("Price: ");
				thePrice = keyIn.nextInt();
				System.out.println();
				// Adding car to the database 
				carDatabase[i] = new Car(theMake, theModel, theYear, thePrice);
			}
			
		} else if (totalAttempts >= 12)  {
			// If total attempts is 12, exit the program
			keyIn.close();
			System.out.println("Program detected suspicious activity and is terminating!");
			System.exit(0);
		}
					
		
		
		
		
	}
	
	
	
	
	
}
