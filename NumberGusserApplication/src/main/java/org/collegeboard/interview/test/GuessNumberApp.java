package org.collegeboard.interview.test;

import java.util.Scanner;

public class GuessNumberApp 
{
	private static int lowerRange;
	private static int higherRange;
	private static int correctNumber;
	
    public static void main(String[] args)
    {
     
	     System.out.println("You need to guess a number between 0 and 100 in your mind and we will guess it for you:) ");
	     System.out.println("------------------------------------------------------------------------------------------");
	     
	     System.out.println("Proceed ? Enter(Y/N)");
	     Scanner scanner=new Scanner(System.in);
	     
	     String proceed=scanner.next();
	     if(proceed.equalsIgnoreCase("Y")){
	       lowerRange=0;
	       higherRange=100;
	  	   startGuessing();
	  	   scanner.close();
	     }else if(proceed.equalsIgnoreCase("Y")){
	  	   scanner.close();
	  	   System.exit(1);
	     }else{
	  	   System.err.println("\n You entered a wrong option , Please try again !!\n");
	     }
    }
    
	
    public static void startGuessing()
    {

       while(true){
    	   
            // this is the same logic which we use in binary search algorithm
            if(lowerRange<higherRange){
            	correctNumber=(lowerRange+higherRange)/2;
            }
            
            String userInputValue =getUserInput(correctNumber);

            switch (userInputValue.toUpperCase()) {
			case "H":lowerRange=correctNumber;
				break;
			case "L":higherRange=correctNumber;
				break;
			case "C": System.out.println("SUCCESS - Correct Guess !!");
			          repeatGuessing();
				break;
			default:   System.err.println("\n You entered a wrong option , Please try again !!\n");
				break;
			}
        }
    }

    private static void repeatGuessing()
    {
    	System.out.println("");
    	System.out.println("**** ----------------------------****");
    	System.out.println("Like to guess again? enter (Y/N) ");
        Scanner inputFromConsole = new Scanner(System.in);
        
        String flag = inputFromConsole.next();
        if(flag.equalsIgnoreCase("Y")){
        	lowerRange=0;
        	higherRange=100;
        }else{
        	System.out.println("Thank You for using Number Guesser App !!");
        	inputFromConsole.close();
        	System.exit(1);
        }
    }


    /*This method checks the various options user is presented with,
     * If the guessed number is Greater than the probable number or Smaller than the probable number
     * or equal to the probable number*/
    public static String getUserInput(int probableNumber)
    {
            Scanner userInputFromConsole = new Scanner(System.in);
            System.out.println("");
            System.out.println("Is the number " + probableNumber + "? ");
            System.out.println("Press");
            System.out.println("h or H - if your number is Greater than "+ probableNumber);
            System.out.println("l or L - if your number is Lower than "+probableNumber +" and");
            System.out.println("c or C - if It is the number you guessed !! :) ");

            // Read option
            String userEnteredValue= userInputFromConsole.next();
            
        return userEnteredValue;
    }
}