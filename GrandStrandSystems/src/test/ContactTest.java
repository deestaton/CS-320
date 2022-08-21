package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contact.Contact;

class ContactTest {

	@Test
	public void testContactConstructor() {
		Contact contact = new Contact("12345", "Dewayne", "Staton", "9515550000", "123 Codeblock Ave");
		assertTrue(contact.getContactID().equals("12345"));
		assertTrue(contact.getFirstName().equals("Dewayne"));
		assertTrue(contact.getLastName().equals("Staton"));
		assertTrue(contact.getPhoneNumber().equals("9515550000"));
		assertTrue(contact.getAddress().equals("123 Codeblock Ave"));
	}
	

	@Test
	void testContactIDWithMoreThanTenChars() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678901", "Dewayne", "Staton", "9515550000", "123 Codeblock Ave");
		});
	}
	
	@Test
	void testContactFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Dewayne Staton", "Staton", "9515550000", "123 Codeblock Ave");
		});
	}
	
	@Test
	void testContactLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Dewayne", "Dewayne Staton", "9515550000", "123 Codeblock Ave");
		});
	}
	
	@Test
	void testContactNumberTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Dewayne", "Staton", "95155500009515550000", "123 Codeblock Ave");
		});
	}
	
	@Test
	void testContactAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Dewayne", "Staton", "9515550000", "123 Codeblock Ave Riverside, CA 92550");
		});
	}


}
