package ca.nait.dmit.controller;

import javax.enterprise.inject.Model;
import javax.validation.constraints.NotNull;

import org.omnifaces.util.Messages;

import ca.nait.dmit.domain.BMI;

@Model	// alias for @Named @RequestedScoped
public class BmiController {

	@NotNull(message="Please enter a weight value")
	private Integer weight;		// getter/setter
	@NotNull(message="Please enter a height value")
	private Integer height;		// getter/setter

	public void submitForm() {	
		BMI bmiInstance = new BMI();
		bmiInstance.setWeight(weight);
		bmiInstance.setHeight(height);
		String message = String.format("Your BMI is %.1f, you are classified as %s and your risk of developing health problems is %s"
				, bmiInstance.bmiValue()
				, bmiInstance.bmiClassification()
				, bmiInstance.healthRisk());
		if( bmiInstance.bmiClassification().equalsIgnoreCase("underweight") 
				||
			bmiInstance.bmiClassification().equalsIgnoreCase("overweight") ) {
			Messages.addGlobalWarn(message);
		} else if( bmiInstance.bmiClassification().equalsIgnoreCase("normal weight") ) {
			Messages.addGlobalInfo(message);
		} else if( bmiInstance.bmiClassification().equalsIgnoreCase("obese class I") ) {
			Messages.addGlobalError(message);
		} else { 
			Messages.addGlobalFatal(message);
		}
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}
		
}
