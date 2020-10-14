package Assignment2_BoundaryValueCases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Robustness {

	// Constructor
	public Robustness() {

	}

	/**
	 * This class is to generate test case inputs for Robustness testing. The number
	 * of inputs will be 6n+1 where n is the number of variables input by the user
	 */
	int min, minplus, nom, maxminus, max, minminus, maxplus, NumberOfVariables, a, i = 0, j = 0, x;
	boolean keepGoing;

	// Get the Number of variables from the User
	public void requiredVariables() {
		System.out.println("\nEnter the number of variables:");
		Scanner variables = new Scanner(System.in);
		NumberOfVariables = variables.nextInt();
	}

	// Get the input range from the user and compute the values
	public int[][] InputRangeValues(int NumberofVar) {
		int[][] finalArray = new int[NumberOfVariables][];
		// This array will contain all the computed values for the variables entered

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
			minminus = min - 1;
			maxplus = max + 1;
			nom = (max + min) / 2;
			minplus = min + 1;
			maxminus = max - 1;
			int arr[][] = { { minminus, min, minplus, nom, maxminus, max, maxplus } };

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
		int temp = 5, input;
		input = (int) Math.pow(temp, NumOfVar);
		Set<ArrayList<Integer>> listOLists = new HashSet<>();
		for (int i = 0; i < NewArray.length; i++) {
			for (int j = 0; j < 7; j++) {
				ArrayList<Integer> singleList = new ArrayList<Integer>();
				for (int k = 0; k < NewArray.length; k++) {
					if (k == i) {
						singleList.add(NewArray[k][j]);
					} else {
						singleList.add(NewArray[k][3]);
					}

				}
				listOLists.add(singleList);
			}
		}
		System.out.println(listOLists.size());

		for (List<Integer> element : listOLists) {
			System.out.println(element.toString().replace("[", "").replace(",", " ").replace("]", ""));
		}
		System.out.println();
	}

}
