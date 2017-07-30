package viensp_p2;
/*
* CPSC 5002, Seattle University
* This is free and unencumbered software released into the public domain
*/
import java.io.*;
import java.util.Scanner;

/**
 * This class takes in a file name and checks for it's validity for 
 * Message Decoder class. Also prints hello and goodbye messages.
 * @author Phillip J Viens
 *
 */
public class SecretMessage {

	/**
	 * main method that calls welcome message
	 * grabs a file name, and checks to see if the file is valid. 
	 * creates an object.
	 * Then prints a short goodbye message.
	 */
	public static void main(String[] args) throws IOException{
		
		Scanner kbd = new Scanner(System.in);
		
		//welcomeMessage();
		String filename = fileTime(kbd);
		isValidFile(filename, kbd);
		MessageDecoder message = new MessageDecoder();
		message.sortLinkedList(filename);
		//message.getPlainTextMessage();
		MessageDecoder.printLinkedList();
		goodbyeMessage();
	}
	
	/**
	 * prints quick welcome message.
	 */
	public static void welcomeMessage() {
		System.out.println("This program reads an encoded message from a "
				+ "\nfile supplied by the user and displays the contents of"
				+ " \nthe message before it was encoded.\n");

	}
	
	/**
	 * prints quick goodbye message
	 */
	public static void goodbyeMessage() {
		System.out.println("\nThanks for playing!\n");
		
	}
	
	/**
	 * has user input a file path.
	 * @param kbd is a Scanner that allows user to input file name. 
	 * @return returns the filename
	 */
	public static String fileTime(Scanner kbd) throws IOException {
		System.out.print("Enter Secret File Name: ");
		String filename = kbd.nextLine();
		
		return filename;
	}
	
	/**
	 * Checks to see if the file name is valid. While file is not
	 * valid program has user put it in a new that is.
	 * @param filename is the string for the file.
	 * @param kbd is the scanner for the user input for fileTime method.
	 * @return boolean isValid if boolean == true.
	 */
	private static boolean isValidFile(String filename, Scanner kbd) throws IOException {
	    File path = new File(filename);
	    boolean isValid = path.exists() && !path.isDirectory();
	    while(!isValid) {
	    	System.out.println("Sorry that file is not valid.");
	    	
	    	fileTime(kbd);
	    }
	    return isValid;
	}
}
