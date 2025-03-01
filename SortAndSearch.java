// This program takes an array of strings, sorts it, and then searches for a user inputted string using Binary Search.

import java.util.Scanner;

public class SortAndSearch {
    public static void main (String[] args) {
        String[] words = {"cat", "hat", "bat", "sat", "pat", "mat", "rat", "fat", "vat"};
        String temp;
        Scanner sc = new Scanner(System.in);
        System.out.println("Word of choice: ");
        String word = sc.nextLine();

        for (int j = 0; j < words.length; j++) {
            for (int i = j + 1; i < words.length; i++) {
                if (words[i].compareTo(words[j]) < 0) {
                    temp = words[j];
                    words[j] = words[i];
                    words[i] = temp;
                }
            }
        }

        int start = 0;
        int end = words.length - 1;
        int midpoint = (start + end) / 2;
        int answer = -1;

        while (start <= end) {
            if (words[midpoint].compareTo(word) > 0) {
                end = midpoint - 1;
            } else if (words[midpoint].compareTo(word) < 0) {
                start = midpoint + 1;
            } else {
                answer = midpoint + 1;
                break;
            }
            midpoint = (start + end) / 2;
        }
        System.out.println("Your word of choice was at position " + answer + " in the array.");
    }
}
