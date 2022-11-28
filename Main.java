/**
 * This program does binary searching
 *
 * By:      Seti Ngabo
 * Version: 1.0
 * Since:   2022-11-08
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * This is Main Class.
 * Main Class.
 */
final class BinarySearch {
    /**
    * The min number for array.
    */
    public static final int min = 0;

    /**
    * The max number for array.
    */
    public static final int max = 999;

    /**
    * The number of elements in the array.
    */
    public static final int size = 250;
    /**
    * Prevent instantiation.
    * Throw an exception IllegalStateException.
    * if this ever is called
    *
    * @throws IllegalStateException
    *
    */

    private BinarySearch() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
    * Function finds the index of a number, using Binary Search recursively.
    *
    * @param userArray array of numbers generated
    * @param userNumber looking for this number
    * @param lowIndex lowest in index
    * @param highIndex highest in index
    * @return binarySearch returns binary
    */

    // Process
    static int binarySearch(final int[] myArray, final int myNumber,
                          final int Int1, final int Int2) {
        final int returnValue;

        if (Int2 >= Int1) {
            final int mid = (Int2 + Int1) / 2;

            if (myArray[mid] == myNumber) {
                returnValue = mid;
            } else if (myArray[mid] > myNumber) {
                returnValue =
                      binarySearch(myArray, myNumber, Int1, mid - 1);
            } else {
                returnValue =
                      binarySearch(myArray, myNumber, mid + 1, Int2);
            }
        } else {
            returnValue = -1;
        }
        return returnValue;
    }

    /**
    * This starting main() function.
    *
    * @param args No args will be used
    */
    public static void main(final String[] args) {
        System.out.println("Binary Search Program");
        try {
                final Random randNumber = new Random();

            // Initializing array of numbers
            final int[] randomNumberArray = new int[size];

            
            for (int count = 0; count
                            < randomNumberArray.length; count++) {
                randomNumberArray[count] = randNumber.nextInt(max) + 1;
            }

            // Array
            final int[] numberArray = randomNumberArray;
            Arrays.sort(numberArray);
            System.out.print("\nSorted list of numbers:\n");
            for (int element: numberArray) {
                final String padded = String.format("%03d", element);
                System.out.print(padded + ", ");
            }
            System.out.print("\n\n");

            // Input & Output
            final Scanner userInput = new Scanner(System.in);
            System.out.print("What number are you searching for in the array");
            System.out.print(" (integer between 0 and 999): ");
            final int user = userInput.nextInt();
            userInput.close();
            System.out.println();

            if (user > max || user < min) {
                throw new Exception();
            } else {
                    final int answer = binarySearch(numberArray,
                                    user, 0, numberArray.length - 1);
                System.out.println();
                System.out.println("Your number is in index: " + answer);
            }

        } catch (Exception e) {
            System.out.println();
            System.out.println("ERROR: Invalid Input");
        }
    }
}


