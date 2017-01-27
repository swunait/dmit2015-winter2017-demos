package ca.nait.dmit.domain;

/**
 * This class is use to calculate a person's body mass index (BMI) and their BMI
 * Category.
 * 
 * @author Sam Wu
 * @version 2011.10.02
 */
public class BMI {

	private int weight;

	private int height;

	public BMI() {
		super();
	}

	public BMI(int weight, int height) {
		super();
		this.weight = weight;
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	  /**
	   * Calculate the body mass index (BMI) using the weight and height of the
	   * person. The BMI of a person is calculated using the formula: BMI = 703 *
	   * weight / (height * height) where weight is in pounds and height is in
	   * inches.
	   * 
	   * @return The body mass index (BMI) value
	   */
	public double bmiValue() {
		return 703.0 * weight / Math.pow(height, 2);
	}

	/**
	   * Determines the BMI Classification of the person using their BMI value and
	   * comparing it against the following table.
	   * <table>
	   * 	<thead>
	   * 		<tr>
	   * 			<th>BMI Category</th>
	   * 			<th>BMI Classification</th>
	   * 			<th>Risk of developing health problems</th>
	   * 		</tr>
	   * 	</thead>
	   * 	<tbody>
	   * 		<tr>
	   * 			<td>&lt; 18.5</td>
	   * 			<td>Underweight</td>
	   * 			<td>Least</td>
	   * 		</tr>
	   * 		<tr>
	   * 			<td>18.50 - 24.99</td>
	   * 			<td>Normal weight</td>
	   * 			<td>Least</td>
	   * 		</tr>
	   * 		<tr>
	   * 			<td>25.00 - 29.99</td>
	   * 			<td>Overweight</td>
	   * 			<td>Increased</td>
	   * 		</tr>
	   * 		<tr>
	   * 			<td>30.00 - 34.99</td>
	   * 			<td>Obese class I</td>
	   * 			<td>High</td>
	   * 		</tr>
	   * 		<tr>
	   * 			<td>35.00 - 39.99</td>
	   * 			<td>Obese class II</td>
	   * 			<td>Very high</td>
	   * 		</tr>
	   * 		<tr>
	   * 			<td>&gt;= 40.00</td>
	   * 			<td>Obese class III</td>
	   * 			<td>Extremely high</td>
	   * 		</tr>
	   * 	</tbody>
	   * </table>
	   *  
	   * @return one of following: underweight, normal, overweight, obese class I, obese class II, obese class III.
	   */
	public String bmiClassification() {
		String classification = null;
		double bmi = bmiValue();
		
		if(bmi < 18.5)
			classification = "Underweight";
		else if(bmi < 25)
			classification = "Normal weight";
		else if(bmi < 30)
			classification = "Overweight";
		else if(bmi < 35)
			classification = "Obese Class I";
		else if(bmi < 40)
			classification = "Obese Class II";
		else
			classification = "Obese Class III";

		return classification;
	}
	
	/**
	   * Determines the Risk of developing health problems of the person using their BMI value and
	   * comparing it against the following table.
	   * <table>
	   * 	<thead>
	   * 		<tr>
	   * 			<th>BMI Category</th>
	   * 			<th>BMI Classification</th>
	   * 			<th>Risk of developing health problems</th>
	   * 		</tr>
	   * 	</thead>
	   * 	<tbody>
	   * 		<tr>
	   * 			<td>&lt; 18.5</td>
	   * 			<td>Underweight</td>
	   * 			<td>Least</td>
	   * 		</tr>
	   * 		<tr>
	   * 			<td>18.50 - 24.99</td>
	   * 			<td>Normal weight</td>
	   * 			<td>Least</td>
	   * 		</tr>
	   * 		<tr>
	   * 			<td>25.00 - 29.99</td>
	   * 			<td>Overweight</td>
	   * 			<td>Increased</td>
	   * 		</tr>
	   * 		<tr>
	   * 			<td>30.00 - 34.99</td>
	   * 			<td>Obese class I</td>
	   * 			<td>High</td>
	   * 		</tr>
	   * 		<tr>
	   * 			<td>35.00 - 39.99</td>
	   * 			<td>Obese class II</td>
	   * 			<td>Very high</td>
	   * 		</tr>
	   * 		<tr>
	   * 			<td>&gt;= 40.00</td>
	   * 			<td>Obese class III</td>
	   * 			<td>Extremely high</td>
	   * 		</tr>
	   * 	</tbody>
	   * </table>
	   *  
	   * @return one of following: increased, least, high, very high, extremely high
	*/
	public String healthRisk() {
		String risk = null;
		double bmi = bmiValue();
		
		if(bmi < 18.5)
			risk = "Increased";
		else if(bmi < 25)
			risk = "Least";
		else if(bmi < 30)
			risk = "Increased";
		else if(bmi < 35)
			risk = "High";
		else if(bmi < 40)
			risk = "Very high";
		else
			risk = "Extremely high";

		return risk;
	}
}
