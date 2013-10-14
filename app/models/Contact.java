package models;

public class Contact {
  
  private long id;
  private String firstName;
  private String lastName;
  private String telephone;
  private String address;
  
  
  /**
   * Creates a new contact.
   * @param id The ID.
   * @param firstName The first name.
   * @param lastName The last name.
   * @param telephone The telephone number.
   * @param address The address
   */
  public Contact(long id, String firstName, String lastName, String telephone, String address) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
    this.address = address;
  }
  
  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  public String getLastName() {
    return lastName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  public String getTelephone() {
    return telephone;
  }
  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }
  public long getId() {
    return id;
  }
  
  public String getAddress() {
    return address;
  }
  
  public void setAddress(String address) {
    this.address = address;
  }
}
