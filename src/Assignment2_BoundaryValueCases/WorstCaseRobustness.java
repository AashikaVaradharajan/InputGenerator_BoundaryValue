package Assignment2_BoundaryValueCases;

import java.util.Arrays;
import java.util.Scanner;

public class WorstCaseRobustness {
	int min, minplus, nom, maxminus, max, minminus, maxplus, NumberOfVariables, i = 0, j = 0, x;
	boolean keepGoing;

	/**
	 * This class is to generate test case inputs for WorstCaseRobustness testing.
	 * The number of inputs will be 7^n where n is the number of variables input by
	 * the user
	 */
	// Constructor
	public WorstCaseRobustness() {

	}

	// Get the Number of variables from the User
	public void requiredVariables() {
		System.out.println("\nEnter the number of variables:");
		Scanner variables = new Scanner(System.in);
		NumberOfVariables = variables.nextInt();
	}

	// Get the input range from the user and compute the values
	public int[][] InputRangeValues(int NumberofVar) {

		int[][] finalArray = new int[NumberOfVariables][5];
		// This array will contain all the computed values for the variables entered

		for (int eachVar = 1; eachVar <= NumberOfVariables; eachVar++) {
			System.out.println(
					"Enter the range of input for variable " + eachVar + " for e.g.,(x,y)\t(x,y]" + "\t[x,y)\t[x,y] ");
			Scanner range = new Scanner(System.in);
			String UserInput = range.nextLine();
			while (keepGoing = true) {

				if ((UserInput.startsWith("(")) && (UserInput.endsWith(")"))) {

					String minimumValue = UserInput.substring(UserInput.indexOf("(") + 1, UserInput.indexOf(","));
					min = Integer.parseInt(minimumValue);
					min = min + 1;
					String maximumValue = UserInput.substring(UserInput.indexOf(",") + 1, UserInput.indexOf(")"));
					max = Integer.parseInt(maximumValue);
					max = max - 1;
					keepGoing = true;
					break;
				} else if ((UserInput.startsWith("(")) && (UserInput.endsWith("]"))) {

					String minimumValue = UserInput.substring(UserInput.indexOf("(") + 1, UserInput.indexOf(","));
					min = Integer.parseInt(minimumValue);
					min = min + 1;
					String maximumValue = UserInput.substring(UserInput.indexOf(",") + 1, UserInput.indexOf("]"));
					max = Integer.parseInt(maximumValue);
					keepGoing = true;
					break;
				} else if ((UserInput.startsWith("[")) && (UserInput.endsWith(")"))) {

					String minimumValue = UserInput.substring(UserInput.indexOf("[") + 1, UserInput.indexOf(","));
					min = Integer.parseInt(minimumValue);
					String maximumValue = UserInput.substring(UserInput.indexOf(",") + 1, UserInput.indexOf(")"));
					max = Integer.parseInt(maximumValue);
					max = max - 1;
					keepGoing = true;
					break;
				} else if ((UserInput.startsWith("[")) && (UserInput.endsWith("]"))) {

					String minimumValue = UserInput.substring(UserInput.indexOf("[") + 1, UserInput.indexOf(","));
					min = Integer.parseInt(minimumValue);
					String maximumValue = UserInput.substring(UserInput.indexOf(",") + 1, UserInput.indexOf("]"));
					max = Integer.parseInt(maximumValue);
					keepGoing = true;
					break;
				} else {
					System.out.println("\n Wrong Input Range.\nEnter a correct input range");
					keepGoing = false;
				}
			}
			nom = (max + min) / 2;
			minplus = min + 1;
			maxminus = max - 1;
			minminus = min - 1;
			maxplus = max + 1;
			int arr[][] = { { minminus, min, minplus, nom, maxminus, max, maxminus } };

			/*
			 * Store the values in a duplicate array row by row, where row is the number of
			 * variables, column is the values computed for each variable -
			 * minminus,min,minplus, nom,maxminus,max,maxminus in this case - 7
			 */

			for (j = 0; j < arr[i].length; j++) {
				finalArray[eachVar - 1] = Arrays.copyOf(arr[i], arr[i].length);
			}

			continue;
		}
		return finalArray;
	}

	public int getNumberOfVariables() {
		return NumberOfVariables;
	}

	public void setNumberOfVariables(int numberOfVariables) {
		NumberOfVariables = numberOfVariables;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public void generateInput(int[][] NewArray, int NumOfVar) {
		int solutions = 1;

		/*
		 * This loop prints the values stored in the NewArray after taking a a cartesian
		 * product of each values in the rows
		 */

		for (int i = 0; i < NewArray.length; solutions *= NewArray[i].length, i++)
			;
		for (int i = 0; i < solutions; i++) {
			int j = 1;
			for (int[] Array : NewArray) {
				System.out.print(Array[(i / j) % Array.length] + " ");
				j *= Array.length;
			}
			System.out.println();
		}

	}

}
