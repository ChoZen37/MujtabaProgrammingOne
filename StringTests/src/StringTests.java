/**
 * @author Mujtaba Ghulam
 * 2026-01-20
 * Description: Just trying out strings in Java
 */

public class StringTests {
    public static void main(String[] args) {
        // Declare a variable
        String myName = "Muj";
        // Use concatenation with a print command
        System.out.println("My name is " + myName.toUpperCase());
        // Another string variable
        String yourName = "Splooge";
        // Re-assign the value
        // yourName = new String("Muj"); this will print false because it creates a new object
        // yourName = "Ken"; this prints true because the constant is the same
        yourName = myName; // this also prints true because you're assigning 1 to the other
        boolean isSameName = myName == yourName;
        System.out.println(isSameName);
    }
}
