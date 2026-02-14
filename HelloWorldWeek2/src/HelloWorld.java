/**
 Author: Mujtaba Ghulam
* Date: 2026/01/20
* Description: Outputting Hello World
*/
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World! :)");

        // Declare and assign a variable
        int myAge = 21;
        // Create a constant
        final int VOTING_AGE = 18;
        // Declare a double value assigning a value
        double ratio;
        // Boolean value
        boolean isLegal = true;
        // Assign a new value to existing variables
        isLegal = myAge >= VOTING_AGE;
        ratio = myAge / VOTING_AGE; // Truncates, does NOT round, output is 1 but if you swap the values it becomes 0
        System.out.println(isLegal);
        System.out.println(ratio);
        // Try out increment operator
        System.out.println(myAge++); // Outputs 21 but if you put ++ before it will increment FIRST and print 22
        System.out.println(myAge);
    }
}