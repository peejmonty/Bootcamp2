package viensp_p2;
/*
* CPSC 5002, Seattle University
* This is free and unencumbered software released into the public domain.
*/
import java.io.*;
import java.util.Scanner;

/**
 * MessageDecoder class that takes in a secret message and
 * deScrambles the linked list.
 * \
 * @author Phillip J Viens
 *
 */
public class MessageDecoder {
	/**
	 * TODO
	 */
	public String filename;
	/**
	 * TODO
	 */
	public Scanner kbd;
	private static Node head = null;
	private int number;
	private char letter;
	private String fullLine;
	private boolean isMalformed;
	
	/**
	 * Constructor
	 * @param filename takes in the filename string 
	 * @param kbd
	 */
	public MessageDecoder(String filename, Scanner kbd) {
		this.filename = filename;
		this.kbd = kbd;
		isMalformed = isMalformed();
		
		
	}
	
	/**
	 * Nested class for the Nodes.
	 *
	 */
	private class Node {
			
		private int number;
		private char letter;
		private Node next;

		/**
		 * Constructor for the Node.
		 * @param letter takes in the character of the secret message.
		 * @param number takes in the int value that corresponds to the char.
		 * @param next is the next node in the sequence.
		 */
		public Node(char letters, int numbers, Node next) {
			number = numbers;
			letter = letters;
			this.next = next;
			
		}	
	}
	
	/**
	 * opens the Scanner file to read the list. Then using
	 * the insertInOrder method sorts the data. 
	 * @throws IOException
	 */
	public void sortLinkedList() 
			throws IOException {
		
		//opens and scans the file.
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);
		
		//reads values from the file.
		while(inputFile.hasNext()){
			fullLine = inputFile.nextLine();
			System.out.println(fullLine);
			letter = fullLine.charAt(0);
			kbd = new Scanner(fullLine);			
			
			//if letter is blank
			//pointer moves on to the next integer. 
			if (letter != ' ') {
				kbd.next();
				if(kbd.hasNextInt()){
					number = kbd.nextInt();
					if(number < 0)
						isMalformed = true;
					
				}
				else
					isMalformed= true;
			}
			else {
				if(kbd.hasNextInt()){
					number = kbd.nextInt();
					//TODO More tests to ensure you can go without that.
					//if(number < 0) {
						//System.out.println("Malformed3");
					//}
					//else {
						//System.out.println("Malformed4");
					//}
				}
			
			//removeDuplicates();
			}
			insertInOrder();
		}
		checkForDuplicates();
		inputFile.close();
		
		
		
	}
	
	/**
	 * Takes in the values of the integers and 
	 * sorts them in non descending order
	*/
	private void insertInOrder() throws IOException {
		
		//Checks to see if the head is null
		//If not puts a new node there
		if(head == null || head.number >= number ) {
			head = new Node(letter, number, head);
		}
		
		//Checks to see if the next node is less than the integer
		//if so puts the new node in the next space. 
		else {
			Node p = head;
			
			//TODO fix while loop and break statement
			do
			{
				if (p.next == null || p.next.number >= number)
				{
					// Insert the node into the list
					Node newNode = new Node(letter, number, p.next);
					p.next = newNode;
					// Insert done
					break;
				}
				else
				{  
					// if neither of those parameters are met
					//pointer moves to the next node.
					p = p.next;
				}
			}while (true);
		}
	}
	
	/**
	 * A toString method that takes the list and
	 * @return
	 */
	public String getPlainTextMessage() {
		String results = "";
		if (isMalformed) {
			results = "File is Malformed. "
					+ "Please fix all duplicates, "
					+ "missing or negative integers";
		}
		else{
			for (Node p = head; p != null; p = p.next) {
				//p = p.next;
				results += p.letter + " ";
			}
		}
		return results;
	}
	
	/**
	 * Checks to see if there are duplicate integers. 
	 * If so flags the file as Malformed.
	 */
	private void checkForDuplicates() throws IOException{
		//System.out.println();
		//System.out.println("Linked list contents with no duplicates: ");
		
		for (Node p = head; p != null; p = p.next) {
			if (p.next != null && p.number == p.next.number)
			{
					isMalformed=true;
			}
		}
	}
	
	/**
	 * TODO
	 * @return
	 */
	private boolean isMalformed() {
		return isMalformed;
	}
	
	/**
	 * prints Linked list of integers
	 */
	/**
	public static void printLinkedList() throws IOException{
		System.out.println();
		//System.out.println("Linked list contents after reading: ");
		for (Node p = head; p != null; p = p.next)
			System.out.println(p.letter + ""
					+ " " + p.number);
	}
	*/
	
	/**
	 * Takes in the filename that the user sets in SecretMessage
	 * @param filename String filename that is used to open file.
	 * @throws IOException for IOs.
	 */
	public void setFilename(String filename) throws IOException{
		this.filename = filename; 
		System.out.println(filename);
	}
}
