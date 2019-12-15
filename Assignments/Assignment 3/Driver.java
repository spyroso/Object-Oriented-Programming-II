/*
 * Spyros Orfanos (40032280), John Gausden (40031355)
 * COMP249
 * Assignment #3
 * Due Date: August 4, 2019 
*/

// -----------------------------------------------------
// Assignment 3
// Question: Part I-IV
// Written by: Spyros Orfanos (40032280) and John Gausden (40031355)
// -----------------------------------------------------

import java.util.*;
import java.io.*;

public class Driver {

	public static void main(String[] args) {

		System.out.println("Welcome to Spyros and John's program.");

		Scanner keyIn = new Scanner(System.in); // to be used for when the user wishes to use an option
		Scanner logReader = null , fileReader = null; // to be used when reding from log file and car files 
		PrintWriter logFile = null; // to be used to write to file
		int input = 0; // user input 
		

		while (input != 3) {

			/**
			 * Main menu presents user with 3 options.
			 */
			System.out.println("\nHere are a list of options: ");
			System.out.println("1: List all files in the directory"); // creates new log.txt file with directory
			System.out.println("2: Process files from the directory"); // opens the log.txt, reads information, writes to report.txt
			System.out.println("3: Exit program");
			
			// user prompt
			System.out.print("Please enter a choice: ");
			input = keyIn.nextInt();
			System.out.println("");


			while (input != (int) input || input > 3 || input < 1) { // make sure user enters a valid choice
				System.out.println("Please enter an integer between 1 and 3 inclusively");
				input = keyIn.nextInt();
			}

			
			if (input == 1) { // option 1

				/**
				 * Option 1 creates a file called log.txt
				 * It navigates through the data folder, and writes all the directories and folders found to log.txt
				 * If the folder is empty, it throws an exception
				 * If the folder is invalid, it throws an exception
				 */
				try {
					
					// create log.txt file to write to. If it exists, we overwrite it. 
					logFile = new PrintWriter("log.txt"); 
					
					// file is taking from data folder
					File dataFolder = new File("src/Data"); 
					
					if (dataFolder.listFiles() == null)  // if empty folder
						throw new EmptyFolderException("Folder is empty."); 	

					displayfiles(logFile, dataFolder); // if not empty then run through the files and write to log.txt
				}

				catch (FileNotFoundException e) { // if displayfiles for dataFolder files through file not found exception
					System.err.println(e.getMessage());
				}

				catch (EmptyFolderException e) { // if displayfiles for the dataFolder file throws an empty folder
					System.err.println(e.getMessage());
				}

				catch (InvalidFileException e) { // if displayfiles for the dataFolder file throws an invalid file exception
					System.err.println(e.getMessage());
				}

				finally { // Tell user writing to text file has ended, even if error occured
					System.out.println("Finished writing directory to text.\n");
					if (logFile != null)
						logFile.close(); // close printwriter
				}

			}

			else if (input == 2) { // option 2
				
				/**
				 * If option 2 is selected, then we create arrays to add car information (make, price, number)
				 * We use these arrays to make the table summarizing the information 
				 * For each .txt file, we read the make and price of the car in the file, and update the table 
				 * We write the table to report.txt
				 */
				
				try {
					logReader = new Scanner(new FileInputStream("log.txt"));
			
					// to get an upper bound for the array size 
					int nbLines = 0; 
					while(logReader.hasNextLine()) {
						String junk = logReader.nextLine();
						nbLines++;
					}
					
					logReader = new Scanner(new FileInputStream("log.txt"));
					fileReader = null;
					FileWriter fw = new FileWriter(new File("report.txt"));
					double[] carPrices = new double[nbLines];
					String[] carMakes = new String[nbLines];
					int[] nbCars = new int[nbLines];
					int count = 0;
					String toWrite, TABLE_HEADER = "SRNo\t\tCarMake\t\tTotalCost\t\tNumberOfCars\n--------------------------------------------------------------------------\n";

			
					while (logReader.hasNext()) {// && count < 10) {

						// reading from the log file (in search for a file)
						File f = new File(logReader.next());						
						
						// file exists and is a not a directory...
						if (f.exists() && !f.isDirectory()) {
							fileReader = new Scanner(f);
							// CAR MAKE
							carMakes[count] = fileReader.nextLine();
							// JUNK STRING
							fileReader.useDelimiter("\\$");
							String junk = fileReader.next();
							// CAR PRICE
							carPrices[count] = Double.parseDouble(fileReader.next());

							// updating the table
							nbCars[count]++;
							for (int j = 0; j < count; j++)
								if (carMakes[j].equals(carMakes[count])) {
									// adding to the sum
									carPrices[j] += carPrices[count];
									// setting to 0
									carPrices[count] = 0;
									carMakes[count] = "";
									nbCars[j]++;
								}

							// Printing the updated table...
							toWrite = "";
							for (int i = 0, j = 0; i < count; i++) {
								if (carPrices[i] != 0)
									toWrite = toWrite + ++j + "\t\t" + carMakes[i] + "\t\t$"
											+ Math.round(carPrices[i] * 100) / 100.0 + "\t\t" + nbCars[i] + "\n";
							}

							// Writing to the file...
							toWrite = TABLE_HEADER + toWrite + '\n';
							fw = new FileWriter("Report.txt"); // clearing file 
							fw.write(toWrite);

							// Increasing count
							count++;

							
							/*
							 * System.out.println(toWrite);
							 * 
							 * Lincoln Aptera Volkswagen Nissan Chevrolet Volvo Chrysler Toyota Ford Pontiac
							 * Mitsubishi Buick Mercedes-Benz Mazda Bentley Honda Subaru Porsche GMC Land
							 * Rover Rolls-Royce Suzuki Saab Mercury Lotus Maybach Audi Saturn Lexus Dodge
							 * BMW Jeep Scion Austin Cadillac
							 */

						}

					}

					System.out.println("Please see the report.txt file for the table.");
					fw.close();
					
				}

				catch (FileNotFoundException e) {
					System.err.println("log file not found!");
				}

				catch (Exception e) {
					System.err.println("Output file problematic ");
				}

			}

			else { // option 3
				
				/**
				 * If option 3 is selected, we close all the scanners/files and the program ends 
				 */
				
				// close files at the end 
				logReader.close();
				fileReader.close();
				keyIn.close(); 
				System.out.println("Program has been ended. Goodbye!");
	
			}

		}


	}

	
	
	/**
	 * Uses recursion to search through a directory and writes the names of sub-directories and files to another file. 
	 * @param aFile the file to write to 
	 * @param aFolder the Directory/Folder to search 
	 * @throws EmptyFolderException
	 * @throws InvalidFileException
	 */
	public static void displayfiles(PrintWriter aFile, File aFolder) throws EmptyFolderException, InvalidFileException {
		// method should take folder as input
		File[] listFiles = aFolder.listFiles((dir, name) -> !name.equals(".DS_Store")); // fill an array with files from folder of aFolder

		// If folder is empty...
		if (listFiles.length == 0) {
			throw new EmptyFolderException("Empty Folder.");
		}

		// Else get files in the folder...
		else {
			for (int i = 0; i < listFiles.length; i++) { // start at 1 bc of .DS_Store file 
				// individually go through the files
				File individualFiles = listFiles[i];

				if (individualFiles.isDirectory() && individualFiles.exists()) { // check if directory
					aFile.println("Directory: " + individualFiles.getAbsolutePath()); // print directory to file
					displayfiles(aFile, individualFiles); // recursive element so we can get to files\
				}

				else { // go through files in directory
					if (individualFiles.isFile() && individualFiles.exists()) { // check if file and present in folder	
						aFile.println("File: " + individualFiles.getAbsolutePath()); // print to the file the path of individual file
					} else {
						throw new InvalidFileException("Error: Input file named" + individualFiles.getName() + " cannot be found");
					}

				}

			}

			aFile.println("");

		}

	}



}