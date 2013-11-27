package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import views.formdata.ContactFormData;

/**
 * Provides in-memory repository for the Contact data.
 * @author Jonathan Ortal
 */

public class ContactDB {

  // private static Map<String, Map<Long, Contact>> contacts = new HashMap<String, Map<Long, Contact>>();

  /**
   * Updates the "database" if id = -1, else updates an old entry.
   * @param user The user
   * @param formData The contact data
   * @return The created contact
   */
  public static void addContact(String user, ContactFormData formData) {
    boolean isNewContact = (formData.id == -1);
    
    // create new contact
    if (isNewContact) {
      Contact contact = new Contact(formData.firstName, formData.lastName, formData.telephone, formData.telephoneType);
      UserInfo userInfo = UserInfo.find().where().eq("email", user).findUnique();
      if (userInfo == null) {
        throw new RuntimeException("Could not find user: " + user);
      }
      userInfo.addContact(contact);
      contact.setUserInfo(userInfo);
      contact.save();
      userInfo.save();
    }
    
    // retrieve from database
    else {
      Contact contact = Contact.find().byId(formData.id);
      contact.setFirstName(formData.firstName);
      contact.setLastName(formData.lastName);
      contact.setTelephone(formData.telephone);
      contact.setTelephoneType(formData.telephoneType);
      contact.save(); 
    }
    
  }

  public static boolean isUser(String user) {    
    return (UserInfo.find().where().eq("email", user).findUnique() != null);
  }
  
  /**
   * Returns the list of contacts.
   * @param user The user
   * @return A list of contacts.
   */
  public static List<Contact> getContacts(String user) {
    UserInfo userInfo = UserInfo.find().where().eq("email", user).findUnique();
    if (userInfo == null) {
      return null;
    }
    else {
      return userInfo.getContacts();
    }
  }

  /**
   * Returns Contact with associated ID.
   * 
   * @param id The ID.
   * @return The retrieved ID.
   */
  public static Contact getContact(String user, long id) {
    Contact contact = Contact.find().byId(id);
    if (contact == null) {
      throw new RuntimeException("Contact ID not found: " + id);
    }
    UserInfo userInfo = contact.getUserInfo();
    if (!user.equals(userInfo.getEmail())) {
      throw new RuntimeException("Invalid user.");
    }

    return contact;
  }
}
