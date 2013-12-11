package tests;

import org.junit.Test;
import play.test.TestBrowser;
import play.libs.F.Callback;
import tests.pages.IndexPage;
import tests.pages.LoginPage;
import tests.pages.NewContactPage;
import static play.test.Helpers.HTMLUNIT;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.testServer;
import static play.test.Helpers.running;
import static org.fest.assertions.Assertions.assertThat;

/**
 * Integration tests running on an instance of the application.
 */
public class IntegrationTest {
  /** The port number for the integration test. */
  private static final int PORT = 3333;

  /**
   * Check to see that the one page can be displayed.
   */
  @Test
  public void testBasicRetrieval() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        // test if on login page
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
      }
    });
  }

  @Test
  public void testLogin() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {    
      // test if able to login
      LoginPage loginPage = new LoginPage(browser.getDriver(), PORT);
      NewContactPage newContactPage = new NewContactPage(browser.getDriver(), PORT);
      IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
      browser.goTo(loginPage);
      loginPage.login();

      browser.goTo("http://localhost:3333/newcontact");
      newContactPage.makeContact("Jo", "Smo", "111-111-1122", "Mobile");
      browser.goTo(indexPage);

      // test if contact added
      assertThat(browser.pageSource()).contains("Jo");

      // test if able to logout
      browser.goTo(indexPage + "/logout");
      // confirm logout
      assertThat(indexPage.isLoggedOut()).isFalse();
      }
    });
  }
}
