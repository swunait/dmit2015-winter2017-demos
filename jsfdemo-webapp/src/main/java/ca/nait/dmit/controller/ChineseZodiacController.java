package ca.nait.dmit.controller;

import java.util.Calendar;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import org.omnifaces.util.Messages;

import ca.nait.dmit.domain.ChineseZodiac;

@Named			// this is a CDI managed bean
@ViewScoped
public class ChineseZodiacController implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotNull(message="Year value is required")
	private Integer birthYear = Calendar.getInstance().get(Calendar.YEAR);
	
	private String animalImageUrl = "/resources/images/chinese_zodiac/chinese_zodiac.jpg";
	
	public Integer getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(Integer birthYear) {
		this.birthYear = birthYear;
		System.out.println("Birth year = " + birthYear);
	}
	public String getAnimalImageUrl() {
		return animalImageUrl;
	}
	public void setAnimalImageUrl(String animalImageUrl) {
		this.animalImageUrl = animalImageUrl;
	}
	
	public void calculate() {
		String animalName = ChineseZodiac.animal(birthYear);
		String message = String.format("%d is the year of the %s", 
				birthYear, animalName);
		System.out.println(message);
		Messages.addGlobalInfo(message);
		animalImageUrl = String.format("/resources/images/chinese_zodiac/zodiac_%s.jpg", 
				animalName.toLowerCase());
		
	}			
	
}



