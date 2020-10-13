package com.cg.userregistration;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration{	
	private static Scanner sc = new Scanner(System.in);
	
	private String firstName, lastName,email,number,password;
	public UserRegistration() {
		super();
	}
	public UserRegistration(String firstName, String lastName, String email, String number, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.number = number;
		this.password = password;
	}
	
	public void initializeDetails() {
		boolean checkFName = validateName(firstName);
		boolean checkLName = validateName(lastName);
		boolean checkEMail = validateEmail(email);
		boolean checkMobile = validateMobile(number);
		boolean checkPass = validatePassword(password);
		System.out.println(checkFName? "Valid First Name." : "Invalid First Name.");
		System.out.println(checkLName? "Valid Last Name." : "Invalid Last Name.");
		System.out.println(checkEMail? "Valid Email." : "Invalid Email.");
		System.out.println(checkMobile? "Valid Mobile Number" : "Invalid Mobile Number");
		System.out.println(checkPass? "Valid Password." : "Invalid Password.");
		if( checkFName && checkLName && checkEMail && checkMobile && checkPass)
			System.out.println("User Registered Successfully.");
		else
			System.out.println("One or more fields are incorrect. Registration Unsuccessful.");
	}
	
	/* UC1 -- Validate First Name */
	/* UC2 -- Validate Last Name */
	public boolean validateName(String Name) {
		try {
			if(Pattern.matches("[A-Z][a-z]{2,}", Name))
				return true;
			else
				throw new RuntimeException();
		}catch(RuntimeException e) {
			throw new InvalidInputException("Invalid Name");
		}
	}
	
	/* UC3 -- Validate Email */
	public boolean validateEmail(String email) {		
		try {
			if(Pattern.matches("[a-z]+([.-]?[a-z0-9]+)*[@][a-z0-9]+[.][a-z]{2,}(.[a-z]+)?", email))
				return true;
			else
				throw new RuntimeException();
		}catch(RuntimeException e) {
			throw new InvalidInputException("Invalid Email");
		} 
	}
	
	/*UC4 -- Validate Mobile Number */
	public boolean validateMobile(String number) {
		try {
			if(Pattern.matches("[0-9]{2}\\s[0-9]{10}", number))
				return true;
			else
				throw new RuntimeException();
		}catch(RuntimeException e) {
			throw new InvalidInputException("Invalid Mobile");
		}
	}
	
	/* UC5 -- UC8 Validate Password
	 * Rule 1. Minimum 8 characters
	 * Rule 2. At least one Upper Case character
	 * Rule 3. At least one numeric character
	 * Rule 4. Exactly one special character
	 * */
	public boolean validatePassword(String password) {		
		try {
			if(Pattern.matches("(?=.*\\d)(?=.*[A-Z])(?=.*[\\S]).{8,}", password)) {
				String splchar = "[\\W]";
				Pattern pat = Pattern.compile(splchar);
				Matcher mat = pat.matcher(password);
				int count = 0;
				while(mat.find()) {count++ ; }
				if(count == 1) {
					return true;
				}
			}
			else
				throw new RuntimeException();
		}catch(RuntimeException e) {
			throw new InvalidInputException("Invalid Password");
		}
		return false;
	}
	
	public void validateInputForInterface() {
		// TODO Auto-generated method stub		
		InvalidInput i1 = firstName -> {return validateName(firstName);};
		InvalidInput i2 = lastName -> {return validateName(lastName);};
		InvalidInput i3 = email -> {return validateEmail(email);};
		InvalidInput i4 = mobile -> {return validateMobile(mobile);};
		InvalidInput i5 = pass -> {return validatePassword(pass);};
		
		boolean check_fname = i1.validateInput(firstName);
		boolean check_lname = i2.validateInput(lastName);
		boolean check_email = i3.validateInput(email);
		boolean check_mobil = i4.validateInput(number);
		boolean check_passw = i5.validateInput(password);
		if( check_fname && check_lname && check_email && check_mobil && check_passw)
			System.out.println("User Registered Successfully.");
	}
	
	public static void main(String[] args) {		
		System.out.println("Welcome to User Registration Problem");
		System.out.println("Enter the first name: ");
		String firstName = sc.next();		
		System.out.println("Enter the last name: ");
		String lastName = sc.next();		
		System.out.println("Enter the email: ");
		String email = sc.next(); sc.nextLine();
		System.out.println("Enter the Mobile Number: ");
		String number = sc.nextLine();
		System.out.println("Enter the Password: ");
		String password = sc.next();
		
		UserRegistration newUser = new UserRegistration(firstName, lastName, email, number, password);
		newUser.initializeDetails();
		newUser.validateInputForInterface();
		sc.close();
	}
}
