package contact;

import java.util.ArrayList;
import java.util.UUID;

public class ContactService {

	private ArrayList<Contact>contacts = new ArrayList<>();
	private String uniqueContactID;
	
	public String createUniqueID() {
		uniqueContactID = UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
		return uniqueContactID;
	}
	
	public void createContact() {
		Contact contact = new Contact(createUniqueID());
		contacts.add(contact);
	}
	
	public void createContact(String firstName) {
		Contact contact = new Contact(createUniqueID(), firstName);
		contacts.add(contact);
	}
	
	public void createContact(String firstName, String lastName) {
		Contact contact = new Contact(createUniqueID(), firstName, lastName);
		contacts.add(contact);
	}
	
	public void createContact(String firstName, String lastName, String phoneNumber) {
		Contact contact = new Contact(createUniqueID(), firstName, lastName, phoneNumber);
		contacts.add(contact);
	}
	
	public void createContact(String firstName, String lastName, String phoneNumber, String address) {
		Contact contact = new Contact(createUniqueID(), firstName, lastName, phoneNumber, address);
		contacts.add(contact);
	}
	
	public void deleteContact(String id) throws Exception {
		contacts.remove(searchContactList(id));
	}
	
	public void updateFirstName(String id, String firstName) throws Exception{
		searchContactList(id).setFirstName(firstName);
	}
	
	public void updateLastName(String id, String lastName) throws Exception{
		searchContactList(id).setLastName(lastName);
	}
	
	public void updatePhoneNumber(String id, String number) throws Exception{
		searchContactList(id).setPhoneNumber(number);
	}
	public void updateAddress(String id, String address) throws Exception{
		searchContactList(id).setAddress(address);
	}

	
	public ArrayList<Contact> getContacts() {
		return contacts;
	}
	
	private Contact searchContactList(String id) throws Exception {
		int i = 0;
		
		while (i < contacts.size()) {
			if (id.equals(contacts.get(i).getContactID())) {
				return contacts.get(i);
			}
			i++;
		}
		throw new Exception("Contact does not exist.");
	}
}
