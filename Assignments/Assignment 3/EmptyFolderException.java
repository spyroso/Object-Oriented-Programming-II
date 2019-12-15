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


public class EmptyFolderException extends Exception{
	
	
	public static final long serialVersionUID = 42L;
	
	
	/**
	 * Constructor for EmptyFolderException class with String argument to display. 
	 * @param Message
	 */
	public EmptyFolderException(String Message) {
		super(Message);	
	}
	
	/**
	 * Default constructor for EmptyFolderException class. 
	 */
	public EmptyFolderException() {
		super("Error: Input directory named XXX cannot be found.");
	}
	
	
	
}