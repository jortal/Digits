package models;
/**
 * 
 * 
 *
 */
public class Contact {
  
  private long id;
  private String firstName;
  private String lastName;
  private String telephone;
  private String telephoneType;
  
  
  /**
   * Creates a new contact.
   * @param id The ID.
   * @param firstName The first name.
   * @param lastName The last name.
   * @param telephone The telephone number.
   * @param telephoneType The telephone type.
   */
  public Contact(long id, String firstName, String lastName, String telephone, String telephoneType) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
    this.telephoneType = telephoneType;
  }
  
  /** 
   * @return the first name.
   */
  public String getFirstName() {
    return firstName;
  }
  
  /**
   * Sets the first name.
   * @param firstName first name.
   */  
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /** 
   * @return The last name.
   */
  public String getLastName() {
    return lastName;
  }
  
  /**
   * Sets the last name.
   * @param lastName last name.
   */  
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  
  /** 
   * @return The telephone number.
   */
  public String getTelephone() {
    return telephone;
  }
  
  /**
   * Sets the telephone number.
   * @param telephone the telephone number.
   */

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }
  
  /** 
   * @return The id.
   */  
  public long getId() {
    return id;
  }
  
  /**
   * @return The telephone type.
   */
  public String getTelephoneType() {
    return telephoneType;
  }
}
