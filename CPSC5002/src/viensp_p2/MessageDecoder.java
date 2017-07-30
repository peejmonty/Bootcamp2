package viensp_p2;
/*
* CPSC 5002, Seattle University
* This is free and unencumbered software released into the public domain.
*/
import java.io.*;
import java.util.Scanner;

/**
 * 
 * @author Phillip J Viens
 *
 */
public class MessageDecoder {
	
	private String filename;
	private static Node head = null;
		
	private class Node {
			
		private int payload;
		private char letter;
		private Node next;
		
		/**
		 * Constructor for the Node.
		 * @param m takes in the letter of the secret message.
		 * @param n takes in the int value of payload.
		 * @param next is the next node in the sequence.
		 */

		public Node(char m, int n, Node next) {
			this.payload = n;
			this.letter = m;
			this.next = next;
			
		}	
	}
	
	/**
	 * opens the Scanner file to read the list. Then using
	 * the insertInOrder method sorts the data. 
	 * @throws IOException
	 */
	public void sortLinkedList(String filename) throws IOException {
		Scanner file = new Scanner(new File(filename));
		while(file.hasNext()) {
			char m = file.next().charAt(0);
			int n = file.nextInt();
			insertInOrder(m, n);
		}
	}
	
	/**
	 * Takes in the values of the integers and 
	 * sorts them in non descending order
	*/
	private void insertInOrder(char m, int n) throws IOException {
		
		//Checks to see if the head is null
		//If not puts a new node there
		if(head == null || head.payload >= n ) {
			head = new Node(m, n, head);
		}
		
		//Checks to see if the next node is less than the integer
		//if so puts the new node in the next space. 
		else {
			Node p = head;
			
			while (true)
			{
				if (p.next == null || p.next.payload >= n)
				{
					// Insert the node into the list
					Node newNode = new Node(m, n, p.next);
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
			while (p.next != null && p.payload == p.next.payload)
			{
					p.next = p.next.next;
			}
			//System.out.println(p.payload);
		}
		printLinkedList();
	}
	
	/**
	 * prints Linked list of integers
	 */
	public static void printLinkedList() throws IOException{
		System.out.println();
		System.out.println("Linked list contents after reading: ");
		for (Node p = head; p != null; p = p.next)
			System.out.println(p.payload + ", " + p.letter);
	}
	
	public void setFilename(String filename) throws IOException{
		this.filename = filename; 
		System.out.println(filename);
	}
}
