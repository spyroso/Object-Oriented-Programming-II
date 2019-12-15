/*
 * Spyros Orfanos (40032280), John Gausden (40031355)
 * COMP249
 * Assignment #3
 * Due Date: August 4, 2019 
*/

// -----------------------------------------------------
// Assignment 3
// Question: Part III
// Written by: Spyros Orfanos (40032280) and John Gausden (40031355)
// -----------------------------------------------------


public class InvalidFileException extends Exception{
	
	
	public static final long serialVersionUID = 43L;
	
	/**
	 * Constructor for InvalidFileException class with String argument to display. 
	 * @param Message
	 */
	public InvalidFileException(String Message) {
		super(Message);
	}
	
	/**
	 * Default constructor for InvalidFileException class. 
	 */
	public InvalidFileException() {
		super("Error: Input file named XXX cannot be found.");
	}
	
	
}