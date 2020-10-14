
package Assignment2_BoundaryValueCases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/*
 * This class is to generate inputs for boundary value cases. The number of test case inputs will be 4n-1 where n
 * is the number of variables that the user feeds. 
 */

public class BoundaryValueAnalysis {
	int min, minplus, nom, maxminus, max, NumberOfVariables, a, i = 0, j = 0, x;
	boolean keepGoing;

	// Constructor
	public BoundaryValueAnalysis() {

	}

	// Gets the Number of variables from the User
	public void requiredVariables() {
		System.out.println("\nEnter the number of variables:");
		Scanner variables = new Scanner(System.in);
		NumberOfVariables = variables.nextInt();
	}

	// Gets the input range from the user and compute the values
	public int[][] InputRangeValues(int NumberofVar) {
		// This array will contain all the computed values for the variables entered
		int[][] finalArray = new int[NumberOfVariables][5];

		for (int eachVar = 1; eachVar <= NumberOfVariables; eachVar++) {
			System.out
					.println("Enter the range for variable " + eachVar + " for e.g., (x,y)\t(x,y]" + "\t[x,y)\t[x,y] ");
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
			int arr[][] = { { min, minplus, nom, maxminus, max } };

			for (j = 0; j < arr[i].length; j++) {
				finalArray[eachVar - 1] = Arrays.copyOf(arr[i], arr[i].length);
			}

			continue;
		}
		return finalArray;
	}

	// Getters and Setters
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

	// This method is responsible for generating the inputs from the variables and
	// ranges
	// input by the user
	public void generateInput(int[][] NewArray, int NumOfVar) {
		int temp = 5, input;
		input = (int) Math.pow(temp, NumOfVar);
		Set<ArrayList<Integer>> listOLists = new HashSet<>();

		for (int i = 0; i < NewArray.length; i++) {

			for (int j = 0; j < 5; j++) {
				ArrayList<Integer> singleList = new ArrayList<Integer>();
				for (int k = 0; k < NewArray.length; k++) {
					if (k == i) {
						singleList.add(NewArray[k][j]);
					} else {
						singleList.add(NewArray[k][2]);
					}

				}
				listOLists.add(singleList);

			}

		}

		// To print the inputs in the list
		for (List<Integer> element : listOLists) {
			System.out.println(element.toString().replace("[", "").replace(",", "  ").replace("]", ""));

		}
		System.out.println();

	}

}
