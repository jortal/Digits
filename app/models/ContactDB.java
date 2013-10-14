package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import views.formdata.ContactFormData;

/**
 * Provides in-memory repository for the Contact data.
 * @author Jonathan Ortal
 *
 */

public class ContactDB {
  
  private static Map<Long, Contact> contacts = new HashMap<>();
  
  /**
   * Updates the "database" if id = 0, else updates an old entry
   * @param formData The contact data
   * @return The created contact
   */
  public static Contact addContact(ContactFormData formData) {
    long idVal = (formData.id == 0) ? contacts.size() + 1 : formData.id;
    Contact contact = new Contact(idVal, formData.firstName, formData.lastName, formData.telephone);
    contacts.put(idVal, contact);
    return contact;
  }
  
  /**
   * Returns the list of contacts.
   * @return A list of contacts.
   */
  public static List<Contact> getContacts() {
    return new ArrayList<>(contacts.values());
  }
  
  /**
   * Returns Contact with associated ID.
   * @param id The ID.
   * @return The retrieved ID.
   */
  public static Contact getContact(long id) {
    Contact contact = contacts.get(id);
    if (contact == null) { 
      throw new RuntimeException("Invalid ID: " + id);      
    }
    return contact;
  }
}
