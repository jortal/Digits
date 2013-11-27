package models;
 
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import play.db.ebean.Model;

/**
 * 
 * 
 *
 */
@Entity
public class Contact extends Model {
  
  private static final long serialVersionUID = 1L;
  
  @Id
  private long id;
  private String firstName;
  private String lastName;
  private String telephone;
  private String telephoneType;
  
  // 0-Many contacts map to one and only one user (UserInfo)
  @ManyToOne
  private UserInfo userInfo;
  
  
  /**
   * Creates a new contact.
   * @param id The ID.
   * @param firstName The first name.
   * @param lastName The last name.
   * @param telephone The telephone number.
   * @param telephoneType The telephone type.
   */
  public Contact(String firstName, String lastName, String telephone, String telephoneType) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
    this.setTelephoneType(telephoneType);
  }

  /**
   * The EBean ORM finder method for database queries on LastTimeStamp.
   * @return The finder method for products.
   */
  public static Finder<Long, Contact> find() {
    return new Finder<Long, Contact>(Long.class, Contact.class);
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

  public UserInfo getUserInfo() {
    return userInfo;
  }

  public void setUserInfo(UserInfo userInfo) {
    this.userInfo = userInfo;
  }

  public void setTelephoneType(String telephoneType) {
    this.telephoneType = telephoneType;
  }
}
