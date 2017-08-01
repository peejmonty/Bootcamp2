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
	 * creates an object. Calls the MessageDecoder Class.
	 * Allows user to repeat as desired.
	 * Then prints a short goodbye message.
	 */
	public static void main(String[] args) throws IOException{
		
		Scanner kbd = new Scanner(System.in);                                                                           
		String input; 		//input for the repeat function
		char repeat;		//repeat for the input function
		
		welcomeMessage();
		do{
			String filename = ValidFile(kbd);
			MessageDecoder message = new MessageDecoder(filename, kbd);
			message.sortLinkedList();
			printResults(message);
			System.out.print("\nWould you like to repeat(y/n): ");
			input = kbd.nextLine();
			repeat = input.charAt(0);
		}while(repeat == 'y' || repeat == 'Y');
		goodbyeMessage();
	}
	
	/**
	 * prints quick welcome message.
	 */
	public static void welcomeMessage() {
		System.out.println("This program reads an encoded message from a "
				+ "\nfile supplied by the user. In a linked list the file "
				+ "\nis decoded nand thecontents are displayed. An error "
				+ "\nmessage occurs if the file is formatted incorrectly the "
				+ "\nmessage once its been decoded.\n");
	}
	
	/**
	 * prints quick goodbye message
	 */
	public static void goodbyeMessage() {
		System.out.println("\nThanks for playing!\n");
		
	}
	
	/**
	 * Has the user input a filename. Then using input validation 
	 * checks to ensure the file exists and has data.
	 * @param kbd is the scanner for the user input for fileTime method.
	 * @return filename String for the filename that is then sent to the
	 * MessageDecoder class in the main method.
	 */
	private static String ValidFile(Scanner kbd) throws IOException {
		System.out.print("\nEnter Secret File Name: ");
		String filename = kbd.nextLine();
	    File path = new File(filename);
	    boolean isValid = path.exists() && !path.isDirectory();
	    while(!isValid){
	    	System.out.println("Sorry that file is not valid.");
	    	System.out.print("Enter Secret File Name: ");
	    	filename = kbd.nextLine();
	    	path = new File(filename);
	    	isValid = path.exists() && !path.isDirectory();
	    }
	    return filename;
	}
	
	/**
	 * Using the getPlainTextMessage method from the instance message,
	 * This method displays either the de-scrambled LinkedList or
	 * an error message saying that the file ins Malformed.
	 * @param MessageDecoder message takes in the message instance of the
	 * MessageDecoder object.
	 */
	public static void printResults(MessageDecoder message) {
		System.out.println();
		System.out.println(message.getPlainTextMessage());
	}
}
