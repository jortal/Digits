package views.formdata;

import java.util.ArrayList;
import java.util.List;
import play.data.validation.ValidationError;

/**
 * 
 * Backing class for form data.
 * 
 */

public class ContactFormData {
  
  private static final int NUM_TELEPHONE_CHARS = 12;
  public String firstName = ""; // first name form field
  public String lastName = ""; // last name form field
  public String telephone = ""; // telephone form field

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
    
    return errors.isEmpty() ? null : errors;
  }

}