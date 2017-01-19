package ca.nait.domain;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class GuestResponse {
	
	@NotBlank(message="Please enter your name")
	private String name;		// generate getter/setter
	
	@NotBlank(message="Please enter your email address")
	@Email(message="Please enter a valid email address")
	private String email;		// generate getter/setter
	
	@NotBlank(message="Please enter your phone number")
	private String phone;		// generate getter/setter
	
	@NotNull(message="Please select whether you'll attend")
	private Boolean willAttend;	// generate getter/setter
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Boolean getWillAttend() {
		return willAttend;
	}
	public void setWillAttend(Boolean willAttend) {
		this.willAttend = willAttend;
	}
	
	

}
