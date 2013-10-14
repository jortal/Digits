package models;

import java.util.ArrayList;
import java.util.List;
import views.formdata.ContactFormData;

/**
 * Provides in-memory repository for the Contact data.
 * @author Jonathan Ortal
 *
 */

public class ContactDB {
  
  private static List<Contact> contacts = new ArrayList<>();
  
  /**
   * Creates/returns new contact, stores it in memory.
   * @param formData The contact data
   * @return The created contact
   */
  public static Contact addContact(ContactFormData formData) {
    Contact contact = new Contact(formData.firstName, formData.lastName, formData.telephone);
    contacts.add(contact);
    return contact;
  }
  
  /**
   * Returns the list of contacts.
   * @return A list of contacts.
   */
  public static List<Contact> getContacts() {
    return contacts;
  }
}
