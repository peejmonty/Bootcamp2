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
	
	private String filename;
	private static Node head = null;
	private int number;
	private char letter;
	private String fullLine;

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
		 * @param letter takes in the letter of the secret message.
		 * @param number takes in the int value of payload.
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
	public void sortLinkedList(String filename) throws IOException {
		File f = new File(filename);
		Scanner file = new Scanner(f);
		System.out.println("print");
		while(file.hasNext()){
			fullLine = file.nextLine();
			System.out.println(fullLine);
			letter = fullLine.charAt(0);
			//System.out.println(letter);
			Scanner kbd = new Scanner(fullLine);			
			
			//if m is blank
			//pointer moves on to the next 
			if (letter == ' ') {
				number = kbd.nextInt();
				//System.out.println("p" + number);
			}
			else {
				kbd.next();
				number = kbd.nextInt();
				//System.out.println(number);
				
			}
			insertInOrder();
			//removeDuplicates();
		}

		
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
			
			while (true)
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
			}
		}
	}
	
	/**
	 * A toString method that takes the list and
	 * @return
	 */
	public String getPlainTextMessage() {
		String results = "";
		for (Node p = head; p != null; p = p.next) {
			//p = p.next;
			results += p.letter + " ";
		}
		
		return results;
	}
	
	/**
	 * removes duplicate nodes and then prints a the list again.
	 */
	private static void removeDuplicates() throws IOException{
		System.out.println();
		System.out.println("Linked list contents with no duplicates: ");
		
		for (Node p = head; p != null; p = p.next) {
			while (p.next != null && p.number == p.next.number)
			{
					p.next = p.next.next;
			}
		}
	}
	
	/**
	 * prints Linked list of integers
	 */
	public static void printLinkedList() throws IOException{
		System.out.println();
		System.out.println("Linked list contents after reading: ");
		for (Node p = head; p != null; p = p.next)
			System.out.println(p.letter + ""
					+ " " + p.number);
	}
	
	public void setFilename(String filename) throws IOException{
		this.filename = filename; 
		System.out.println(filename);
	}
}
