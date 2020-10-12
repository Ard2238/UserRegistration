package com.cg.userresgistration.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.cg.userregistration.UserRegistration;

public class UserRegistrationTest {
	UserRegistration user_reg;
	@Before
	public void initialize() {
		user_reg = new UserRegistration();
	}
	
	@Test
	public void validateDetails() {
		boolean[] case_true = {user_reg.validateName("Abhishek"),user_reg.validateName("Das"),user_reg.validateEmail("abhishek@xyz.com"),user_reg.validateMobile("91 9953503212"),user_reg.validatePassword("abHi12shEk@")};	
		boolean[] expected_true = {true, true, true, true ,true};
		
		boolean[] case_false = { user_reg.validateName("ab"), user_reg.validateName("da"), user_reg.validateEmail("100.@.com.com"),  user_reg.validateEmail("9953503212"), user_reg.validatePassword("abhi@%#")};
		boolean[] expected_false = {false, false, false, false, false};
		
		assertArrayEquals(expected_true, case_true);
		assertArrayEquals(expected_false, case_false);
	}
//	@Test
//	public void validateDetails_FirstName() {
//		assertEquals(true, user_reg.validateName("Abhishek"));
//	}
//	
//	@Test
//	public void validateDetails_LastName() {
//		assertEquals(true, user_reg.validateName("Das"));	
//	}
//	
//	@Test
//	public void validateDetails_Email() {
//		assertEquals(true, user_reg.validateEmail("abhishek@xyz.com"));
//	}
//	
//	@Test
//	public void validateDetails_Mobile() {
//		assertEquals(true, user_reg.validateMobile("91 9953503212"));
//	}
//	
//	@Test
//	public void validateDetails_Password() {
//		assertEquals(true, user_reg.validatePassword("abHi12shEk@"));
//	}

}
