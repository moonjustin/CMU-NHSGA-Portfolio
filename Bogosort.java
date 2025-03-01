// This program takes an array of numbers, and performs Bogosort until the numbers are fully sorted.

import java.util.Arrays;
import java.util.Random;

public class bogoSort {
    public static void main(String[] args) {
        Integer[] numbersToBeSorted = {5, 4, 3, 2, 1, 0};
        bogoSort(numbersToBeSorted);
    }

    public static Boolean bogoSort(Integer[] numbers) {
        while (!isSorted(numbers)) {
            randomize(numbers);
            System.out.println(Arrays.toString(numbers));
        }
        System.out.println("Sorted!");
        return true;
    }

    public static void randomize(Integer[] numbers) {
        Random random = new Random();
        for (int i = numbers.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int a = numbers[index];
            numbers[index] = numbers[i];
            numbers[i] = a;
        }
    }

    public static Boolean isSorted(Integer[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
