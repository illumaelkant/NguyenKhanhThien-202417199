import java.util.Arrays;
import java.util.Scanner;

public class EX5_5_Sol {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int size = scanner.nextInt();
        double[] array = new double[size];
        System.out.println("Enter " + size + " numeric values:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextDouble();
        }
        Arrays.sort(array);
        double sum = 0;
        for (double num : array) {
            sum += num;
        }
        double average = sum / size;
        System.out.println("Sorted Array: " + Arrays.toString(array));
        System.out.println("Sum of array elements: " + sum);
        System.out.println("Average of array elements: " + average);
        scanner.close();
    }
}


