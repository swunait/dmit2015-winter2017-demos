package ca.nait.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import org.omnifaces.util.Messages;

@Named		// allows you to access an instance of this class using JSF-EL (Expression Language)
@RequestScoped	// create an instance of this class for one HTTP request
public class BmiController {

	@NotNull(message="Please enter a weight value")
	private Double weight;		// getter/setter
	@NotNull(message="Please enter a height value")
	private Double height;		// getter/setter
	
	private double calculateBmi(double weight, double height) {
		// bmiValue = 703 * weight / height^2
		return 703.0 * weight / Math.pow(height, 2);
	}
	
	public void submitForm() {
		double bmiValue = calculateBmi(weight, height);
		// Send a info message to FacesContext
//		String message = String.format("Your BMI is %.1f", bmiValue);
		
//		FacesContext facesContext = FacesContext.getCurrentInstance();
//		FacesMessage facesMessage = new FacesMessage(message);
//		facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
//		facesContext.addMessage(null, facesMessage);	
		if( bmiValue < 18.5 ) {
			String message = String.format("Your BMI is %.1f, you are underweight", bmiValue);
			Messages.addGlobalWarn(message);			
		} else if( bmiValue >= 18.5 && bmiValue <= 24.99 ) {
			String message = String.format("Your BMI is %.1f, you are at optimal weight", bmiValue);
			Messages.addGlobalInfo(message);						
		} else if( bmiValue >= 25 && bmiValue < 30 ) {
			String message = String.format("Your BMI is %.1f, eat less you are over-weight", bmiValue);
			Messages.addGlobalError(message);									
		} else {
			String message = String.format("Your BMI is %.1f, please see you doctor now", bmiValue);
			Messages.addGlobalFatal(message);			
		}
		
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}
	
}
