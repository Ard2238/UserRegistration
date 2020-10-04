package com.cg.userregistration;

import java.util.Scanner;
import java.util.regex.Pattern;

public class UserRegistration {
	/* UC1 -- Validate First Name */
	/* UC2 -- Validate Last Name */
	private static boolean validateName(String firstName) {
		return Pattern.matches("[A-Z][a-z]{2,}", firstName);
	}
	
	/* UC3 -- Validate Email */
	private static boolean validateEmail(String email) {		
		return Pattern.matches("[a-z]+(.[a-z]+)*@{1}[a-z]+(.co){1}(.[a-z]+)*", email);
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
		
		System.out.println("Enter the email: ");
		String email = sc.next();
		System.out.println(validateEmail(email)? "Valid Email." : "Invalid Email.");
		sc.close();
	}

}
