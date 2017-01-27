package ca.nait.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import ca.nait.domain.GuestResponse;
import helper.Gmail;

// mark this class as a JSF CDI-managed bean class
@Named	// allows you to access an instance of this class using JSF-EL (Expression Language)
@RequestScoped	// create an instance for one HTTP request and destroy it after the HTTP response is sent
				// @ViewedScoped	// keep instance until HTTP request for another page
				// @SessionScoped	// allows instance to be shared across multiple pages for one client
				// @ApplicationScoped	// one instance is shared with ALL clients (global data)
public class RsvpFormController {

	private GuestResponse guestResponse = new GuestResponse();	// getter/setter
	
	public GuestResponse getGuestResponse() {
		return guestResponse;
	}
	public void setGuestResponse(GuestResponse guestResponse) {
		this.guestResponse = guestResponse;
	}

	// an "action" method returns a String to the next page
	// an "actionListener" does not return a value and navigation stays on the same page
	public String submitForm() {
		System.out.println(guestResponse);
		Gmail mailer = new Gmail("swu.nait@gmail.com", "myPassword");
		String mailMessage = "";
		if (guestResponse.getWillAttend() ) {
			mailMessage = "It's great taht you're are coming to my party. Thank you are awesome";
		} else {
			mailMessage = "Sorry to hear that you can't make it. A gift is still expected.";
		}
		try {
			mailer.sendmail("swu.nait@gmail.com", 
					guestResponse.getEmail(), 
					"Party Invitation", 
					mailMessage);
		} catch (Exception e) {
			System.out.println("Cannot send email");
		}
		
		
		return "/thanks?faces-redirect=true";
	}
		
}
