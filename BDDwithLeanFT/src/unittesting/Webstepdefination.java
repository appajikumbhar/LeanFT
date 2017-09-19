package unittesting;

import com.hp.lft.sdk.web.*;
import com.hp.lft.verifications.Verify;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@SuppressWarnings("unused")
public class Webstepdefination {
	Browser browser, browser1;
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
		browser.sync();
		browser.close();
		
	}
	
	//Flight management scenario
	@Given("^Navigate to Flight management site$")
	public void navigate_to_Flight_management_site() throws Throwable {
		browser = BrowserFactory.launch(BrowserType.CHROME);    
		browser.navigate("http://newtours.demoaut.com/");
	}

	@Given("^Enter Username as Mercury$")
	public void enter_Username_as_Mercury() throws Throwable {
			
		browser.describe(Link.class, new LinkDescription.Builder()
				.innerText("SIGN-ON")
				.tagName("A").build()).click();
		

		browser.describe(EditField.class, new EditFieldDescription.Builder()
				.name("userName")
				.tagName("INPUT")
				.type("text").build()).setValue("mercury");	
	}

	@Given("^Enter Password as Mercury$")
	public void enter_Password_as_Mercury() throws Throwable {
		browser.describe(EditField.class, new EditFieldDescription.Builder()
				.name("password")
				.tagName("INPUT")
				.type("password").build()).setSecure("7fb14b221c620fab960fab");
	}

	@When("^user click on login button$")
	public void user_click_on_login_button() throws Throwable {
		browser.describe(Image.class, new ImageDescription.Builder()
				.alt("Login")
				.tagName("INPUT")
				.type(com.hp.lft.sdk.web.ImageType.BUTTON).build()).click();
	}

	@Then("^navigate to next page$")
	public void navigate_to_next_page() throws Throwable {
	    browser.sync();
	    Verify.areEqual(browser.getTitle(), "Find a Flight: Mercury Tours:");
	    browser.close();
	}
	
	//Ticket booking
	@Given("^User is on Find Flight page$")
	public void user_is_on_Find_Flight_page() throws Throwable {
		browser = BrowserFactory.launch(BrowserType.CHROME);    
		browser.navigate("http://newtours.demoaut.com/");
		
		browser.describe(Link.class, new LinkDescription.Builder()
				.innerText("Flights")
				.tagName("A").build()).click();
	}

	@When("^user select the  Flight Details$")
	public void user_select_the_Flight_Details() throws Throwable {
		

		browser.describe(ListBox.class, new ListBoxDescription.Builder()
				.name("passCount")
				.tagName("SELECT").build()).select("2");

		browser.describe(ListBox.class, new ListBoxDescription.Builder()
				.name("fromPort")
				.tagName("SELECT").build()).select("London");

		browser.describe(ListBox.class, new ListBoxDescription.Builder()
				.name("fromDay")
				.tagName("SELECT").build()).select("15");

		browser.describe(ListBox.class, new ListBoxDescription.Builder()
				.name("toPort")
				.tagName("SELECT").build()).select("Paris");

		browser.describe(ListBox.class, new ListBoxDescription.Builder()
				.name("toDay")
				.tagName("SELECT").build()).select("20");
	}

	@When("^Select the Preferences for the flight$")
	public void select_the_Preferences_for_the_flight() throws Throwable {
		browser.describe(RadioGroup.class, new RadioGroupDescription.Builder()
				.name("servClass")
				.tagName("INPUT").build()).select("First");

		browser.describe(ListBox.class, new ListBoxDescription.Builder()
				.name("airline")
				.tagName("SELECT").build()).select("Unified Airlines");
	}

	@When("^then click on continue$")
	public void then_click_on_continue() throws Throwable {
		browser.describe(Image.class, new ImageDescription.Builder()
				.alt("")
				.tagName("INPUT")
				.type(com.hp.lft.sdk.web.ImageType.BUTTON).build()).click();
	}

	@Then("^user must be directed to Select Flight page$")
	public void user_must_be_directed_to_Select_Flight_page() throws Throwable {
	   
	    Verify.areEqual(browser.getTitle(), "Select a Flight: Mercury Tours");	
		browser.sync();
	}

	@Then("^Select the Depart plane$")
	public void select_the_Depart_plane() throws Throwable {
		browser.describe(RadioGroup.class, new RadioGroupDescription.Builder()
				.name("outFlight")
				.tagName("INPUT").build()).select("Pangea Airlines$362$274$9:17");
	}

	@Then("^Select the Return plan$")
	public void select_the_Return_plan() throws Throwable {
		browser.describe(RadioGroup.class, new RadioGroupDescription.Builder()
				.name("inFlight")
				.tagName("INPUT").build()).select("Blue Skies Airlines$631$273$14:30");
	}

	@Then("^Click on Continue button$")
	public void click_on_Continue_button() throws Throwable {
		browser.describe(Image.class, new ImageDescription.Builder()
				.alt("")
				.tagName("INPUT")
				.type(com.hp.lft.sdk.web.ImageType.BUTTON).build()).click();
	}

	@Then("^User must be directed to Book a flight page$")
	public void user_must_be_directed_to_Book_a_flight_page() throws Throwable {
		browser.sync();
		Verify.areEqual(browser.getTitle(), "Book a Flight: Mercury Tours");	
		
	}

	@Then("^Verify the Flight details$")
	public void verify_the_Flight_details() throws Throwable {
		browser.sync();
	}

	@Then("^enter the Passenger Details$")
	public void enter_the_Passenger_Details() throws Throwable {

		browser.describe(EditField.class, new EditFieldDescription.Builder()
				.name("passFirst0")
				.tagName("INPUT")
				.type("text").build()).setValue("Demo1");

		browser.describe(EditField.class, new EditFieldDescription.Builder()
				.name("passLast0")
				.tagName("INPUT")
				.type("text").build()).setValue("Test");

		browser.describe(ListBox.class, new ListBoxDescription.Builder()
				.name("pass.0.meal")
				.tagName("SELECT").build()).select("Hindu");

		browser.describe(EditField.class, new EditFieldDescription.Builder()
				.name("passFirst1")
				.tagName("INPUT")
				.type("text").build()).setValue("Demo2");

		browser.describe(EditField.class, new EditFieldDescription.Builder()
				.name("passLast1")
				.tagName("INPUT")
				.type("text").build()).setValue("Test");

		browser.describe(ListBox.class, new ListBoxDescription.Builder()
				.name("pass.1.meal")
				.tagName("SELECT").build()).select("Low Calorie");
	}

	@Then("^enter the Credit card details$")
	public void enter_the_Credit_card_details() throws Throwable {
		browser.describe(ListBox.class, new ListBoxDescription.Builder()
				.name("creditCard")
				.tagName("SELECT").build()).select("Visa");

		browser.describe(EditField.class, new EditFieldDescription.Builder()
				.name("creditnumber")
				.tagName("INPUT")
				.type("text").build()).setValue("1234567890");

		browser.describe(ListBox.class, new ListBoxDescription.Builder()
				.name("cc_exp_dt_mn")
				.tagName("SELECT").build()).select("11");

		browser.describe(ListBox.class, new ListBoxDescription.Builder()
				.name("cc_exp_dt_yr")
				.tagName("SELECT").build()).select("2010");

		browser.describe(EditField.class, new EditFieldDescription.Builder()
				.name("cc_frst_name")
				.tagName("INPUT")
				.type("text").build()).setValue("Demo1");

		browser.describe(EditField.class, new EditFieldDescription.Builder()
				.name("cc_mid_name")
				.tagName("INPUT")
				.type("text").build()).setValue("Demo");

		browser.describe(EditField.class, new EditFieldDescription.Builder()
				.name("cc_last_name")
				.tagName("INPUT")
				.type("text").build()).setValue("Test");
	}

	@Then("^Click on secure purchase button$")
	public void click_on_secure_purchase_button() throws Throwable {
		browser.describe(Image.class, new ImageDescription.Builder()
				.alt("")
				.tagName("INPUT")
				.type(com.hp.lft.sdk.web.ImageType.BUTTON).build()).click();

	}

	@Then("^User must be  directed to Flight confirmation page$")
	public void user_must_be_directed_to_Flight_confirmation_page() throws Throwable {
		browser.sync();
		Verify.areEqual(browser.getTitle(), "Flight Confirmation: Mercury Tours");	
	}

	@Then("^Click on Log out button$")
	public void click_on_Log_out_button() throws Throwable {
		browser.describe(Link.class, new LinkDescription.Builder()
				.innerText("SIGN-OFF")
				.tagName("A").build()).click();
		}

	@Then("^User will be directed to Sign on page$")
	public void user_will_be_directed_to_Sign_on_page() throws Throwable {
		Verify.areEqual(browser.getTitle(), "Sign-on: Mercury Tours");	
		browser.close();
	}


}






















