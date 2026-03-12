import java.util.InputMismatchException;
import java.util.Scanner;

class Calculator {

    int[] arr = new int[3];

    public void performOperations() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter first number: ");
            int num1 = sc.nextInt();

            System.out.print("Enter second number: ");
            int num2 = sc.nextInt();

            if (num2 == 0) {
                System.out.println("Error: Cannot divide by zero!");
                return;
            }

            int result = num1 / num2;
            System.out.println("Division Result: " + result);

            System.out.print("Enter index to store result (0-" + (arr.length - 1) + "): ");
            int index = sc.nextInt();

            try {
                arr[index] = result;
                System.out.println("Stored successfully in array at index " + index + ".");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("ArrayIndexOutOfBoundsException: Attempted index " + index + ", valid range 0-" + (arr.length - 1));
                System.out.println("Exception message: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (InputMismatchException e) {
            System.out.println("Input error: please enter valid integers.");
        } catch (Exception e) {
            System.out.println("General Exception Occurred: " + e.toString());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Calculator().performOperations();
    }
}