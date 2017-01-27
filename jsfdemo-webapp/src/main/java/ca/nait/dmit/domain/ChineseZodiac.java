package ca.nait.dmit.domain;

/**
 * In the Chinese calendar, every year is associated with a particular animal. 
 * The 12-year animal cycle is rat, ox, tiger, rabbit, dragon, snake, horse, goat (or ram), monkey, rooster, dog, and pig (or boar). 
 * The year 1900 is a year of the rat; thus 1901 is a year of the ox and 1912 is another year of the rat. 
 * If you know in what year person was born, you can compute the offset from 1900 and determine the animal associated with that 
 * person’s year of birth.
 * 
 * @author Sam Wu
 * @version 2015.01.16
 */
public class ChineseZodiac {
	
	/**
	   * Determine the animal associated with a person's year of birth.
	   * The animal of the person can be calculated by subtracting 1900 from the birth year
	   * and calculate the offset from 12.
	   * ------------------------
	   * | Offset 	| Animal	|
	   * -----------------------
	   * | 0	  	| Rat		|
	   * | 1		| Ox		|
	   * | 2		| Tiger		|
	   * | 3		| Rabbit	|
	   * | 4		| Dragon	|
	   * | 5		| Snake		|
	   * | 6		| Horse		|
	   * | 7		| Goat		|
	   * | 8		| Monkey	|
	   * | 9		| Rooster	|	
	   * | 10		| Dog		|
	   * | 11		| Pig		|
	   * |-----------------------
	   * @return the animal of the person
	   */
	  public static String animal(int birthYear)
	  {
		String animal = null;

		int yearOffset = (birthYear - 1900) % 12;
		
//		switch( yearOffset )
//		{
//		case 0:
//		  animal = "Rat";
//		  break;
//		case 1:
//		  animal = "Ox";
//		  break;
//		case 2:
//		  animal = "Tiger";
//		  break;
//		case 3:
//		  animal = "Rabbit";
//		  break;
//		case 4:
//		  animal = "Dragon";
//		  break;
//		case 5:
//		  animal = "Snake";
//		  break;
//		case 6:
//		  animal = "Horse";
//		  break;
//		case 7:
//		  animal = "Goat";
//		  break;
//		case 8:
//		  animal = "Monkey";
//		  break;
//		case 9:
//		  animal = "Rooster";
//		  break;
//		case 10:
//		  animal = "Dog";
//		  break;
//		case 11:
//		  animal = "Pig";
//		  break;	  
//		}
		
		String[] animals = {"Rat","Ox","Tiger","Rabbit","Dragon","Snake","Horse","Goat","Monkey","Rooster","Dog","Pig"};
		animal = animals[ yearOffset ];
		
		return animal;
	  }
}
