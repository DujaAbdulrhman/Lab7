
import java.util.Scanner;

public class arat {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an index number: ");
        int index = scanner.nextInt();

        try {
            int number = numbers[index];
            System.out.println("Number at index " + index + ": " + number);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index is out of bounds!");
        }
    }
}