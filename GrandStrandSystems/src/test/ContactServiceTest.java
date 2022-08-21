package test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import contact.ContactService;

public class ContactServiceTest {

	protected String contactIdTest, firstNameTest, lastNameTest, phoneNumberTest, 
	addressTest, contactIdTooLong, firstNameTooLong, lastNameTooLong, phoneNumberTooLong,
	phoneNumberTooShort, addressTooLong;
	
	@BeforeEach
	void setUp() {
		contactIdTest = "0101010101";
		firstNameTest = "Siri";
		lastNameTest = "Macintosh";
		phoneNumberTest = "9515550000";
		addressTest = "One Apple Pkwy";
		
		contactIdTooLong = "0101010101010100101010";
		firstNameTooLong = "First Name Too Long";
		lastNameTooLong = "Last Name Too Long";
		phoneNumberTooLong = "95155500000";
		phoneNumberTooShort = "951555000";
		addressTooLong = "One Apple Pkwy Cupertino, CA";
	}
	
	@Test
	void createContactTest() {
	ContactService service = new ContactService();
		
		service.createContact();
		
		assertAll("service", () -> assertNotNull(service.getContacts().get(0).getContactID()),
		() -> assertNotNull(firstNameTest, service.getContacts().get(0).getFirstName()),
		() -> assertNotNull(lastNameTest, service.getContacts().get(0).getLastName()),
		() -> assertNotNull(phoneNumberTest, service.getContacts().get(0).getPhoneNumber()),
		() -> assertNotNull(addressTest, service.getContacts().get(0).getAddress()));
	}
	
	@Test
	void deleteContactTest() {
		ContactService service = new ContactService();
		service.createContact();
		assertThrows(Exception.class, () -> service.deleteContact(contactIdTest));
		assertAll(() -> service.deleteContact(service.getContacts().get(0).getContactID()));
	}
	
	@Test
	void updateFirstNameTest() throws Exception {
		ContactService service = new ContactService();
		service.createContact();
		service.updateFirstName(service.getContacts().get(0).getContactID(), firstNameTest);
		assertEquals(firstNameTest, service.getContacts().get(0).getFirstName());
		assertThrows(Exception.class, () -> service.updateFirstName(contactIdTest, firstNameTest));
	}
	
	@Test
	void updateLastNameTest() throws Exception {
		ContactService service = new ContactService();
		service.createContact();
		service.updateLastName(service.getContacts().get(0).getContactID(), lastNameTest);
		assertEquals(lastNameTest, service.getContacts().get(0).getLastName());
		assertThrows(Exception.class, () -> service.updateLastName(contactIdTest, lastNameTest));
	}
	
	@Test
	void updatePhoneNumberTest() throws Exception {
		ContactService service = new ContactService();
		service.createContact();
		service.updatePhoneNumber(service.getContacts().get(0).getContactID(), phoneNumberTest);
		assertEquals(phoneNumberTest, service.getContacts().get(0).getPhoneNumber());
		assertThrows(Exception.class, () -> service.updatePhoneNumber(contactIdTest, phoneNumberTest));
	}
	
	@Test
	void updateContactAddressTest() throws Exception {
		ContactService service = new ContactService();
		service.createContact();
		service.updateAddress(service.getContacts().get(0).getContactID(), addressTest);
		assertEquals(addressTest, service.getContacts().get(0).getAddress());
		assertThrows(Exception.class, () -> service.updateAddress(contactIdTest, addressTest));
	}

}
