package bsu.comp152;
import java.util.Scanner;

/**
 * AverageValue -
 * A class for Project 2, COMP 152
 *
 * Completed by: Andrew Janedy, ajanedy@student.bridgew.edu, 2/13/23 (completed 2/21/23)
 */
public class AverageValue {

    /**
     * main method simply creates a scanner object
     * and prompts the user for their name, then prints it
     * @param args
     */
    public static void main(String[] args) {
        // creation of a scanner object for reading input
        Scanner answer = new Scanner(System.in);
        System.out.println("Enter a number (Q or q to quit)");
        String userAnswer = answer.next();
        if (userAnswer.charAt(0) == 'Q' || userAnswer.charAt(0) == 'q') {
            System.out.println("No data to calculate");
            System.exit(0);
        }
        else {
            collectData(Double.parseDouble(userAnswer));
        }
    }

    /**
     * findAverage takes two parameters, the total of user input numbers
     * and the amount of numbers, returns the average.  This is called
     * from the collect data method
     * @param userNumber
     * @param numberCount
     * @return
     */
    public static double findAverage(double userNumber, int numberCount) {
        return userNumber / numberCount;
    }

    /**
     * collectData uses a while loop to collect data from the user
     * then calls the findAverage function
     * @param collectedData
     */
    public static void collectData(double collectedData) {
        // declaration and initialization of variables that will
        // be used as arguments for findAverage method
        double cumulativeTotal = collectedData;
        int runningCount = 1;
        String userInput = "0";
        // a while loop that runs until user enters "Q" or "q"
        while (userInput.charAt(0) != 'Q' || userInput.charAt(0) != 'q') {
            Scanner nextAnswer = new Scanner(System.in);
            System.out.println("Enter a number (Q or q to quit)");
            userInput = nextAnswer.next();
            // if statement calls method isDouble which uses a try catch
            // to return a boolean, checking to see if the user input
            // can be converted to a double.  If it returns true then the
            // user input an integer or a double and the number will be
            // added to the cumulative total and the running count will
            // be incremented
            if (isDouble(userInput)) {
                cumulativeTotal += Double.parseDouble(userInput);
                runningCount += 1;
            }
            // then checks to see if the user intended to quit
            else if (userInput.charAt(0) == 'Q' || userInput.charAt(0) == 'q'){
                System.out.println(findAverage(cumulativeTotal, runningCount));
                break;
            }
            // otherwise input was invalid and it continues through the loop
            else {
                continue;
            }
        }
    }

    /**
     * isDouble method is a simple try catch to see determine
     * what data type our user input
     * @param stringToCheck
     * @return
     */
    public static boolean isDouble(String stringToCheck) {
        try {
            Double.parseDouble(stringToCheck);
            return true;
        } catch (NumberFormatException NFE) {
            return false;
        }
    }
}