package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import views.formdata.ContactFormData;

/**
 * Provides in-memory repository for the Contact data.
 * 
 * @author Jonathan Ortal
 * 
 */

public class ContactDB {

  private static Map<String, Map<Long, Contact>> contacts = new HashMap<String, Map<Long, Contact>>();

  /**
   * Updates the "database" if id = 0, else updates an old entry.
   * @param user The user
   * @param formData The contact data
   * @return The created contact
   */
  public static Contact addContact(String user, ContactFormData formData) {
    long idVal = (formData.id == 0) ? contacts.size() + 1 : formData.id;
    Contact contact =
        new Contact(idVal, formData.firstName, formData.lastName, formData.telephone, formData.telephoneType);
    if(!contacts.containsKey(user)) {
      contacts.put(user, new HashMap<Long, Contact>());
    }
    
    contacts.get(user).put(idVal, contact);
    return contact;
  }

  /**
   * Returns the list of contacts.
   * 
   * @return A list of contacts.
   */
  public static List<Contact> getContacts(String user) {
    if(!contacts.containsKey(user)) {
      return null;
    }
    return new ArrayList<>(contacts.get(user).values());
  }

  /**
   * Returns Contact with associated ID.
   * 
   * @param id The ID.
   * @return The retrieved ID.
   */
  public static Contact getContact(String user, long id) {
    Contact contact = contacts.get(user).get(id);
    if(!contacts.containsKey(user)) {
      throw new RuntimeException("Invalid user: " + user);
    }
    if (contact == null) {
      throw new RuntimeException("Invalid ID: " + id);
    }
    return contact;
  }
}
