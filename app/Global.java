import models.ContactDB;
import models.UserInfoDB;
import play.*;
import views.formdata.ContactFormData;

/**
 * Initializes contact information page.
 * @author Jonathan Ortal
 */
public class Global extends GlobalSettings {
  
  public void onStart(Application app) {

    UserInfoDB.addUserInfo("John Smith", "smith@example.com", "password");
    ContactDB.addContact("smith@example.com", new ContactFormData("Joe", "Smith", "808-555-0008", "Home"));
    ContactDB.addContact("smith@example.com", new ContactFormData("Jane", "Smith", "808-555-0009", "Mobile"));

    UserInfoDB.addUserInfo("John Doe", "doe@example.com", "password");
    ContactDB.addContact("doe@example.com", new ContactFormData("Jill", "Smith", "808-555-0010", "Mobile"));
    ContactDB.addContact("doe@example.com", new ContactFormData("Jack", "Smith", "808-555-0011", "Work"));
    ContactDB.addContact("doe@example.com", new ContactFormData("Jack", "Smith", "808-555-0011", "Work"));
    ContactDB.addContact("doe@example.com", new ContactFormData("Jack", "Smith", "808-555-0011", "Work"));

    
  }
  
}
