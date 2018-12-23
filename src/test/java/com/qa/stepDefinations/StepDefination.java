package com.qa.stepDefinations;


import com.qa.common.Keywords;
import com.qa.pages.FlightFinder;
import com.qa.pages.LoginPage;
import com.qa.pages.PassengerDetails;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.testng.Assert;


public class StepDefination   {

	@Given("^Login with Username as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
	public void login(String userName , String password)
	{
		LoginPage.loginToApp(userName, password);
		String title = LoginPage.getPageTitle();
		Assert.assertEquals("Find a Flight: Mercury Tours:", title);
        
    }
	
	@Given("^Search Flight for Type as \"([^\"]*)\" , Passenger Count \"([^\"]*)\" , Departure from \"([^\"]*)\" , On \"([^\"]*)\" \"([^\"]*)\" , Arrival to \"([^\"]*)\" , On \"([^\"]*)\" \"([^\"]*)\" in Class as \"([^\"]*)\" and Preferred class as \"([^\"]*)\"$")
	public void searchFlight(String type , 
			 String passengerCount , 
			 String departure , 
			 String fromMonth , 
			 String fromDay , 
			 String arrival , 
			 String toMonth , 
			 String toDay , 
			 String serviceClass , 
			 String preference
			 ) {
		
		FlightFinder.searchFight(type, passengerCount, departure, fromMonth, fromDay, arrival, toMonth, toDay, serviceClass, preference);
	}
	
	@Given("^Entering Passenger details First Name as \"([^\"]*)\" , Last Name as \"([^\"]*)\" and Creditcard No as \"([^\"]*)\"$")
	public void enterPassenderDetails(String firstName,
			 String lastName,
			 String creditCardNo
			 ) {
		PassengerDetails.inputPassengerDetail(firstName, lastName, creditCardNo);
	}
	
	@When ("^User Books Confirms Flight Booking$")
	public void secureFlight() {
		PassengerDetails.clickSecureFlight();
	}
	
	@Then("^Flight Should be booked successfully$")
	public void verifyFlightBooking() {
		Assert.assertTrue(Keywords.doesPageContainsText("Your itinerary has been booked!"));
	}
	
	@Then("^User SignOut$")
	public void signoutApp() {
		LoginPage.signOut();
	}
}
	