package ca.nait.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import ca.nait.domain.GuestResponse;

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
		
		return "/thanks?faces-redirect=true";
	}
		
}
