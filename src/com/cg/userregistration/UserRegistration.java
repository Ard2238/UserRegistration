package com.cg.userregistration;

import java.util.Scanner;
import java.util.regex.Pattern;

public class UserRegistration {	
	private static Scanner sc = new Scanner(System.in);
	
	/* UC1 -- Validate First Name */
	/* UC2 -- Validate Last Name */
	private static boolean validateName(String firstName) {
		return Pattern.matches("[A-Z][a-z]{2,}", firstName);
	}
	
	/* UC3 -- Validate Email */
	private static boolean validateEmail(String email) {		
		return Pattern.matches("[a-z]+(.[a-z]+)*@{1}[a-z]+(.co){1}(.[a-z]+)*", email);
	}
	
	/*UC4 -- Validate Mobile Number */
	private static boolean validateMobile(String number) {
		return Pattern.matches("[0-9]{2}\\s[0-9]{10}", number);
	}
	
	/* UC5 -- UC8 Validate Password
	 * Rule 1. Minimum 8 characters
	 * Rule 2. At least one Upper Case character
	 * Rule 3. At least one numeric character
	 * Rule 4. Exactly one special character
	 * */
	private static boolean validatePassword(String password) {
		return Pattern.matches("(?=.*\\d)(?=.*[A-Z])?(?=.*\\W).{8,}", password);
	}
	
	public static void main(String[] args) {		
		System.out.println("Welcome to User Registration Problem");
		System.out.println("Enter the first name: ");
		String firstName = sc.next();
		System.out.println(validateName(firstName)? "Valid First Name." : "Invalid First Name.");
		
		System.out.println("Enter the last name: ");
		String lastName = sc.next();
		System.out.println(validateName(lastName)? "Valid Last Name." : "Invalid Last Name.");
		
		System.out.println("Enter the email: ");
		String email = sc.next();
		System.out.println(validateEmail(email)? "Valid Email." : "Invalid Email.");
		
		System.out.println("Enter the Mobile Number: ");
		String number = sc.next();
		System.out.println(validateMobile(number)? "Valid Mobile Number" : "Invalid Mobile Number");
		
		System.out.println("Enter the Password: ");
		String password = sc.next();
		System.out.println(validatePassword(password)? "Valid Password." : "Invalid Password.");
		sc.close();
	}

}
