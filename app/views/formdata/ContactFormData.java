package views.formdata;

import java.util.ArrayList;
import java.util.List;
import models.Contact;
import play.data.validation.ValidationError;

/**
 * 
 * Backing class for form data.
 * 
 */

public class ContactFormData {
  
  private static final int NUM_TELEPHONE_CHARS = 12;
  
  /** ID field. **/
  public long id = -1; 
  /** First name form field. **/
  public String firstName = ""; 
  /** Last name form field. **/
  public String lastName = ""; 
  /** Telephone. **/
  public String telephone = ""; 
  /** Telephone type. **/
  public String telephoneType = "";
  
  /** No argument constructor. **/
  public ContactFormData() {
    // no arg constructor
  }
  
  
  
  /**
   * Constructs a ContactFormData object manually for the purpose of initializing the contact table.
   * @param firstName The first name.
   * @param lastName The last name.
   * @param telephone The telephone number.
   * @param telephoneType The telephone type.
   */
  public ContactFormData(String firstName, String lastName, String telephone, String telephoneType) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
    this.telephoneType = telephoneType;
  }

  /**
   * Constructor for the contact list.
   * @param contact The list of contacts.
   */
  
  public ContactFormData(Contact contact) {
    this.id = contact.getId();
    this.firstName = contact.getFirstName();
    this.lastName = contact.getLastName();
    this.telephone = contact.getTelephone();
    this.telephoneType = contact.getTelephoneType();
  }

  /**
   * Validates form input by the user.
   * All fields must not be empty.
   * Telephone must be 12 characters.
   * @return null if no errors, list of ValidationErrors if there are errors.
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();
    
    if (firstName == null || firstName.length() == 0) {
      errors.add(new ValidationError("firstName", "First name is required."));
    }

    if (lastName == null || lastName.length() == 0) {
      errors.add(new ValidationError("lastName", "Last name is required."));
    }

    if (telephone.length() != NUM_TELEPHONE_CHARS) {
      errors.add(new ValidationError("telephone", "Telephone must be xxx-xxx-xxxx"));
    }
    
    if (!TelephoneTypes.isType(telephoneType)) {
      errors.add(new ValidationError("telephoneType", "Telephone type must be Home, Work, or Mobile"));      
    }
    return errors.isEmpty() ? null : errors;
  }

}