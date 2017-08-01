package viensp_p2;

/*
* CPSC 5002, Seattle University
* This is free and unencumbered software released into the public domain.
*/
import java.io.*;
import java.util.Scanner;

/**
 * MessageDecoder class that takes in a secret message and deScrambles the
 * linked list.
 * @author Phillip J Viens
 *
 */
public class MessageDecoder {

	/**
	 * filename String that is taken when the use inputs in SecretMessage Class
	 */
	public String filename;

	/**
	 * Takes in the Scanner from the SecretMessage class.
	 */
	public Scanner kbd;
	private static Node head = null; 	// head Node for LinkedList
	private int number; 				// int number for the number value.
	private char letter; 				// char for the secretMessage.
	private String stringLine; 			// temp string to take in full line.
	private boolean malformed; 			// boolean checks if linked list is malformed.
	private String results; 			// String that gets sent to secretMessage Class

	/**
	 * Constructor
	 * @param filename takes in the filename string
	 * @param kbd takes in the scanner.
	 */
	public MessageDecoder(String filename, Scanner kbd) {
		this.filename = filename;
		this.kbd = kbd;
		malformed = isMalformed();
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
	 * opens the Scanner file to read the list. Then using the insertInOrder
	 * method sorts the data.
	 * @throws IOException
	 */
	public void sortLinkedList() throws IOException {

		// opens and scans the file.
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);

		// reads values from the file.
		while (inputFile.hasNext()) {
			stringLine = inputFile.nextLine();
			letter = stringLine.charAt(0);
			kbd = new Scanner(stringLine);

			// if letter is blank
			// pointer moves on to the next integer.
			if (letter != ' ') {
				kbd.next();
				if (kbd.hasNextInt()) {
					number = kbd.nextInt();
					if (number < 0)
						malformed = true;
				} else
					malformed = true;
			} else {
				if (kbd.hasNextInt()) {
					number = kbd.nextInt();
				}
			}
			insertInOrder();
		}
		checkForDuplicates();
		inputFile.close();
	}

	/**
	 * Takes in the values of the integers and sorts them in non descending
	 * order
	 */
	private void insertInOrder() {

		// Checks to see if the head is null
		// If not puts a new node there
		if (head == null || head.number >= number) {
			head = new Node(letter, number, head);
		}

		// Checks to see if the next node is less than the integer
		// if so puts the new node in the next space.
		else {
			Node p = head;
			while (p.next != null && p.next.number < number)
				p = p.next;

			p.next = new Node(letter, number, p.next);
		}
	}

	/**
	 * That returns a parsed method to stay within 80 characters
	 * @return parsedResults that starts a new line after 78.
	 */
	public String getPlainTextMessage() {
		results = "";

		// Checks to see if the message is malformed
		// returns error message if so.
		if (malformed) {
			results = "File is Malformed. " + "Please fix all duplicates, " + "missing or negative integers";
		}
		// else returns the results of the Decoded Message.
		else {
			for (Node p = head; p != null; p = p.next) {
				results += p.letter + " ";
			}
		}
		String parsedResults = results.replaceAll("(.{78})", "$1\n");
		return parsedResults;
	}

	/**
	 * Checks to see if there are duplicate integers. If so flags the file as
	 * Malformed.
	 */
	private void checkForDuplicates() throws IOException {
		for (Node p = head; p != null; p = p.next) {
			if (p.next != null && p.number == p.next.number) {
				malformed = true;
			}
		}
	}

	/**
	 * If the file has any missing, duplicate, or negative integers it returns
	 * isMalformed.
	 * @return isMalformed if file is in correct.
	 */
	private boolean isMalformed() {
		return malformed;
	}
}
