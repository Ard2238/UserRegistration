package com.cg.userregistration;

import java.util.Scanner;
import java.util.regex.Pattern;

public class UserRegistration {
	/* UC1 -- Validate First Name */
	/* UC2 -- Validate Last Name */
	private static boolean validateName(String firstName) {
		return Pattern.matches("[A-Z][a-z]{2,}", firstName);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		System.out.println("Welcom to User Registration Problem");
		System.out.println("Enter the first name: ");
		String firstName = sc.next();
		System.out.println(validateName(firstName)? "Valid First Name." : "Invalid First Name.");
		
		System.out.println("Enter the last name: ");
		String lastName = sc.next();
		System.out.println(validateName(lastName)? "Valid Last Name." : "Invalid Last Name.");
		sc.close();
	}

}
