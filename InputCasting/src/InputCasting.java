import java.util.Scanner;
public class InputCasting {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[]args){
        double fahrenheit;
        double celsius;
        String userInput;
        System.out.println("Enter a Fahrenheit temperature: ");
        userInput = input.nextLine();
        fahrenheit = Double.parseDouble(userInput);
        celsius = (fahrenheit - 32) * 5 / 9;
        System.out.printf("%.2f° Fahrenheit is %.2ff° Celsius\n", fahrenheit, celsius);
        //System.out.printf("%-8.3f° Fahrenheit is %8.3f° Celsius", fahrenheit, celsius);
        System.out.printf("%8.2f° Fahrenheit is %8.2f° Celsius\n", fahrenheit, celsius);
        System.out.printf("%-8.3f° Fahrenheit is %8.3f° Celsius\n", fahrenheit, celsius);
        System.out.printf("%30s° Fahrenheit is %30s°%n Celsius\n", fahrenheit, celsius);

    }
}
