package com.cg.userresgistration.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.cg.userregistration.UserRegistration;

@RunWith(Parameterized.class)
public class UserReg_ParameterizedTest {
	
	/* 1. Input variables
	 * 2. output values
	 * 3. object of the class to be tested
	 */
	private String mail;
	private boolean expected;
	private UserRegistration user_reg;
	
	// Constructor	
	public UserReg_ParameterizedTest(String mail, boolean expected) {
		this.mail = mail;
		this.expected = expected;
	}
	
	// to create a set of input data for individual tests
	@Parameterized.Parameters
	public static Collection data(){
		return Arrays.asList(new Object[][] {{"abc@yahoo.com", true }, {"abc-100@yahoo.com", true}, {"abc.100@yahoo.com", true},
												{"abc111@abc.com", true}, {"abc-100@abc.net", true}, {"abc.100@abc.com.au", true},
												{"abc@1.com", true}, {"abc@gmail.com.com", true}, {"abc", false}, {"abc@.com.my", false}, 
												{"abc123@gmail.a", false}, {"abc123@.com", false}, {"abc123@.com.com", false}, 
												{".abc@abc.com", false}, {"abc()*@gmail.com", false}, {"abc@%*.com", false}, 
												{"abc..2002@gmail.com", false}, {"abc.@gmail.com", false}, {"abc@abc@gmail.com", false}, 
												{"abc@gmail.com.1a", false}, {"abc@gmail.com.aa.au", false}
		});
	}
	
	// before any test case
	@Before
	public void initialize() {
		user_reg = new UserRegistration();
	}
	
	// Actual Test
	@Test
	public void validateMail_ParamTest() {
		assertEquals(expected, user_reg.validateEmail(mail));
	}
	

}
