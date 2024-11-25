import java.util.Scanner;

public class LinearEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Linear Equation Program");
        System.out.println("Given a equation as 'a * x + b = 0', please enter constants:");
        System.out.print("a = ");
        double a = scanner.nextDouble();
        System.out.print("b = ");
        double b = scanner.nextDouble();
        if (a == 0) {
            if (b == 0) {
                System.out.println("The equation has infinite solutions");
            } else {
                System.out.println("The equation has no solution");
            }
        } else {
            double x = -b / a;
            System.out.println("The equation has one solution: x = " + x);
        }
        scanner.close();
    }
}
