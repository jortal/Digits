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

    ContactDB.addContact(new ContactFormData("Joe", "Smith", "808-555-0008", "Home"));
    ContactDB.addContact(new ContactFormData("Jane", "Smith", "808-555-0009", "Mobile"));
    ContactDB.addContact(new ContactFormData("Jill", "Smith", "808-555-0010", "Mobile"));
    ContactDB.addContact(new ContactFormData("Jack", "Smith", "808-555-0011", "Work"));
    UserInfoDB.addUserInfo("John Smith", "smith@example.com", "password");
      
  }
  
}
