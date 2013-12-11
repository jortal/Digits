package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
// Although Eclipse marks the following two methods as deprecated, 
// the no-arg versions of the methods used here are not deprecated.  (as of May, 2013).
import static org.fluentlenium.core.filter.FilterConstructor.withText; 
import static org.fluentlenium.core.filter.FilterConstructor.withId;  
import static org.fest.assertions.Assertions.assertThat;

/**
 * Implements index page behavior.  
 * @author Philip Johnson
 */
public class IndexPage extends FluentPage {
  private String url;
  
  /**
   * Create the IndexPage.
   * @param webDriver The driver.
   * @param port The port.
   */
  public IndexPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port;
  }
  
  @Override
  public String getUrl() {
    return this.url;
  }
  
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("digits: Home");
  }
  
  /**
   * Click login link.
   */
  public void goToLogin() {
    find("#login").click();
  }
  
  /**
   * Returns true if user logged in.
   * @return true or false
   */
  public boolean isLoggedIn() {
    return !find("#logout").isEmpty();
  }
  
  public void goToNewContact() {
    find("#newcontact").click();
  }
  
  /**
   * Logs out a user.
   */
  public void logout() {
    find("#logout");
  }
}
