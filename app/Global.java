import models.UserInfo;
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
    
    String adminEmail = Play.application().configuration().getString("digits.admin.email");
    String adminPassword = Play.application().configuration().getString("digits.admin.password");
    
    UserInfoDB.addAdmin("Administrator", adminEmail, adminPassword);

    if (UserInfoDB.isAdmin()) {
      ContactDB.addContact(adminEmail, new ContactFormData("Joe", "Smith", "808-555-0008", "Home"));
      ContactDB.addContact(adminEmail, new ContactFormData("Jane", "Smith", "808-555-0009", "Mobile"));
    }
    
    UserInfoDB.addUserInfo("Jumbalaya Smith", "jumba@example.com", "password");    
    ContactDB.addContact("jumba@example.com", new ContactFormData("Jill", "Smith", "808-555-0010", "Mobile"));
    ContactDB.addContact("jumba@example.com", new ContactFormData("Jack", "Smith", "808-555-0011", "Work"));
     
  }
  
}
