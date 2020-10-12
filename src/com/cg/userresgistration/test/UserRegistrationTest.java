package com.cg.userresgistration.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.cg.userregistration.InvalidInputException;
import com.cg.userregistration.UserRegistration;

public class UserRegistrationTest {
	UserRegistration user_reg;
	@Before
	public void initialize() {
		user_reg = new UserRegistration();
	}
	
//	@Test
//	public void validateDetails() {
//		boolean[] case_true = {user_reg.validateName("Abhishek"),user_reg.validateName("Das"),user_reg.validateEmail("abhishek@xyz.com"),user_reg.validateMobile("91 9953503212"),user_reg.validatePassword("abHi12shEk@")};	
//		boolean[] expected_true = {true, true, true, true ,true};
//		
//		boolean[] case_false = { user_reg.validateName("ab"), user_reg.validateName("da"), user_reg.validateEmail("100.@.com.com"),  user_reg.validateEmail("9953503212"), user_reg.validatePassword("abhi@%#")};
//		boolean[] expected_false = {false, false, false, false, false};
//		
//		assertArrayEquals("Entry Successful", expected_true, case_true);
//		assertArrayEquals("Entry failed", expected_false, case_false);
//	}
	@Test
	public void validateDetails_FirstName() {
		try {
			user_reg.validateName("Abhishek");
			user_reg.validateName("ab");
		}catch(InvalidInputException e) {
			assertEquals("Invalid Name", e.getMessage());
		}
	}
	
	@Test
	public void validateDetails_LastName() {
		try {
			user_reg.validateName("Das");
			user_reg.validateName("da");
		}catch(InvalidInputException e) {
			assertEquals("Invalid Name", e.getMessage());
		}
	}
	
	@Test
	public void validateDetails_Email() {
		try {
			user_reg.validateEmail("abhishek@xyz.com");
			user_reg.validateEmail("100.@.com.com");
		}catch(InvalidInputException e) {
			assertEquals("Invalid Email", e.getMessage());
		}
	}
	
	@Test
	public void validateDetails_Mobile() {
		try {
			user_reg.validateMobile("91 9953503212");
			//user_reg.validateEmail("9953503212");
		}catch(InvalidInputException e) {
			assertEquals("Invalid Mobile", e.getMessage());
		}
	}
	
	@Test
	public void validateDetails_Password() {
		try {
			user_reg.validatePassword("abHi12shEk@");
			user_reg.validatePassword("abhi@%#");
		}catch(InvalidInputException e) {
			assertEquals("Invalid Password", e.getMessage());
		}
	}

}
