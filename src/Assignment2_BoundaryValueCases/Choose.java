package Assignment2_BoundaryValueCases;


import java.util.Scanner;

/*
 * Class Name: Choose
 * This Class has the main method that prompts the  user to select one of the 4 methods in order to generate test
 * case inputs. They are 1. Boundary Value Analysis 2. Robustness 3. Worst Case 4. WorstCase Robustness
 */

public class Choose {
	
	public static void main(String[] args) {
		
		int input;
		boolean KeepGoing = true;
		WorstCase worstcase = new WorstCase();
		BoundaryValueAnalysis boundaryvalue = new BoundaryValueAnalysis();
		Robustness robustness = new Robustness();
		WorstCaseRobustness worstcaserob = new WorstCaseRobustness();
		
    	while(KeepGoing) {
    	// Getting the user input on which program has to be executed
    		
    		System.out.println("Please choose one of the following options: \n 1. Boundary Value Analysis \n 2. Robustness Testing" + 
    			" \n 3. Worst-case Testing \n 4. Worst-case Robustness Testing");
    		Scanner userInput = new Scanner(System.in);
    		input = userInput.nextInt();
    		if(input == 1) {
    			boundaryvalue.requiredVariables();
    			boundaryvalue.generateInput(boundaryvalue.InputRangeValues(boundaryvalue.getNumberOfVariables()), boundaryvalue.getNumberOfVariables());
    			KeepGoing = true;
    			break;	
		
    		}else if (input == 2) {				
    			robustness.requiredVariables();
    			robustness.generateInput(robustness.InputRangeValues(robustness.getNumberOfVariables()), robustness.getNumberOfVariables());
    			KeepGoing = true;
    			break;
				
    		}else if(input == 3) {
				worstcase.requiredVariables();
    			worstcase.generateInput(worstcase.InputRangeValues(worstcase.getNumberOfVariables()), worstcase.getNumberOfVariables());
    			KeepGoing = true;
    			break;	
				
    		} else if (input == 4) {
				worstcaserob.requiredVariables();
    			worstcaserob.generateInput(worstcaserob.InputRangeValues(worstcaserob.getNumberOfVariables()), worstcaserob.getNumberOfVariables());
    			KeepGoing = true;
    			break;
				
				
    		}else {			
				
				System.out.println("\nInvalid Option.");
				
			}
			
    	}
		    
	}
}
