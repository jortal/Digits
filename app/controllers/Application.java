package controllers;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.Index;
import views.html.NewContact;
import views.formdata.ContactFormData;
import models.ContactDB;
import views.html.Index2;

/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page. 
   * @return The resulting home page. 
   */

  public static Result index() {
    return ok(Index.render(ContactDB.getContacts()));
  }
    
  /**
   * Returns newcontact page
   * @param id The id to get or create a new instance if id is zero
   * @return the NewContact page.
   */
  public static Result newContact(long id) {    
    ContactFormData data = (id == 0) ? new ContactFormData() : new ContactFormData(ContactDB.getContact(id));
    Form<ContactFormData> formData = Form.form(ContactFormData.class).fill(data);
    return ok(NewContact.render(formData));
  }
  
  /**
   * Handles post of form data
   * @return the NewContact page.
   */
  public static Result postContact() {
    Form<ContactFormData> formData = Form.form(ContactFormData.class).bindFromRequest();
    if (formData.hasErrors()) {
      return badRequest(NewContact.render(formData));
    }
    ContactFormData data = formData.get();
    ContactDB.addContact(data);
    return ok(NewContact.render(formData));
  }
  
  
  /**
   * @param id The id of the contact to delete
   * @return The contact page, minus the deleted contact
   */
  public static Result deleteContact(long id) {
    ContactDB.deleteContact(id);
    return ok(Index.render(ContactDB.getContacts()));
  }
}
