/**
 * @author Mujtaba Ghulam
 * Date: 2026/01/20
 * Description: Calculates the are of a slive of pizza
 */

public class PizzaSlice {
    public static void main(String[] args) {
    final double MEDIUM_PIZZA_DIAMETER = 14;
    int numberOfSlices = 8;
    double pizzaRadius;
    double pizzaArea;
    double sliceArea;
    pizzaRadius = MEDIUM_PIZZA_DIAMETER / 2;
    pizzaArea = Math.PI * Math.pow(pizzaRadius, 2);
    sliceArea = Math.round(100 * pizzaArea / numberOfSlices) / 100.0;
    System.out.println(sliceArea);
    }
}
