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

    if (UserInfoDB.isAdmin() && UserInfoDB.getUser(adminEmail).getContacts().isEmpty()) {
      ContactDB.addContact(adminEmail, new ContactFormData("Joe", "Smith", "808-555-0008", "Home"));
      ContactDB.addContact(adminEmail, new ContactFormData("Jane", "Smith", "808-555-0009", "Mobile"));
    }
     
  }
  
}
