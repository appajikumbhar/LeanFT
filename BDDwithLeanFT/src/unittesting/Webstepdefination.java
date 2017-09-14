package unittesting;

import com.hp.lft.sdk.web.*;
import com.hp.lft.verifications.Verify;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Webstepdefination {
	Browser browser;
	@Given("^a user goes to google$")
	public void a_user_goes_to_google() throws Throwable {
		browser = BrowserFactory.launch(BrowserType.CHROME);
	    browser.navigate("https://www.google.co.in");
	}

	@Given("^search for HPE$")
	public void search_for_HPE() throws Throwable {
		browser.describe(EditField.class, new EditFieldDescription.Builder()
				.name("q")
				.tagName("INPUT")
				.type("text").build()).setValue("HPE");
				
		browser.describe(Button.class, new ButtonDescription.Builder()
				.buttonType("submit")
				.name("Google Search")
				.tagName("INPUT").build()).click();
	}

	@When("^he clicks on the link$")
	public void he_clicks_on_the_link() throws Throwable {
		browser.describe(Link.class, new LinkDescription.Builder()
				.innerText("Hewlett Packard Enterprise (HPE) | India")
				.tagName("A").build()).click();
	}

	@Then("^the page should appear$")
	public void the_page_should_appear() throws Throwable {
		Verify.areEqual(browser.getTitle(), "Hewlett Packard Enterprise (HPE) | India");
		
	}
}
