import javax.swing.JOptionPane;

public class Calculator {
    public static void main(String[] args) {
        String strNum1, strNum2;
        String strNotification = "You've just entered: ";

        strNum1 = JOptionPane.showInputDialog(null, "Please enter the first number: ", "Input the first number",
                JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum1 + " and ";

        strNum2 = JOptionPane.showInputDialog(null, "Please enter the second number: ", "Input the second number",
                JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum2;

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        // Calculate the sum, difference, product, divide of two numbers

        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;

        System.out.println("The sum of " + strNotification + " is: " + sum);
        System.out.println("The difference of " + strNotification + " is: " + difference);
        System.out.println("The product of " + strNotification + " is: " + product);
        if (num2 != 0) {
            double divide = num1 / num2;
            System.out.println("The divide of " + strNotification + " is: " + divide);
        } else {
            System.out.println("The second number is 0, so the divide is not valid");
        }

    }
}
