/*
* This program generates all of the
* possible 3x3 squares.
*
* @author  Sydney Kuhn
* @version 1.0
* @since   2023-01-04
*/

import java.util.ArrayList;

/**
 * The MagicSquare class.
 */
final class MagicSquare {
    /**
     * The lower right index.
     */
    public static final int EIGHT = 8;

    /**
     * The middle right index.
     */
    public static final int FIVE = 5;

    /**
     * The center index.
     */
    public static final int FOUR = 4;

    /**
     * The maximum number for magicNumbers.
     */
    public static final int MAGICNUM = 15;

    /**
     * The maximum number for magicNumbers.
     */
    public static final int NINE = 9;

    /**
     * The lower center index.
     */
    public static final int SEVEN = 7;

    /**
     * The lower left index.
     */
    public static final int SIX = 6;

    /**
     * The middle left index.
     */
    public static final int THREE = 3;

    /**
     * The MagicSquare.
     *
     * <p>
     * Prevent instantiation.
     * </p>
     *
     * @throws IllegalStateException - error
     */
    private MagicSquare() {
        // Prevent instantiation
        // Optional: throw an exception e.g. AssertionError
        // if this ever *is* called
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
     * The magicSquare function.
     *
     * @param nums - the list of numbers from 1 to 9.
     * @param currentSquare - the current square being filled.
     * @param index - the current index.
     */
    public static void magicSquare(final int[] nums,
        final int[] currentSquare, final int index) {
        // Checks if the square is fille and magic.
        if (index == NINE && isMagic(currentSquare)) {
            printMagicSquare(currentSquare);
        } else {
            // Adds a number to the square if it's not full.
            if (index != NINE) {
                // Loops through each number from 1 to 9.
                for (int count = 0; count < NINE; count++) {
                    currentSquare[index] = nums[count];
                    magicSquare(nums, currentSquare, index + 1);
                }
            }
        }
    }

    /**
     * The findDuplicates function.
     *
     * @param arr - the array to find duplicates in.
     * @return ArrayList
     */
    public static ArrayList<Integer> findDuplicates(int[] arr) {
        final ArrayList<Integer> duplicates = new ArrayList<Integer>();

        for (int counter = 0; counter < arr.length; counter++) {
            for (int counter1 = 1; counter1 < arr.length; counter1++) {
                if (arr[counter] == arr[counter1] && counter != counter1) {
                    duplicates.add(arr[counter1]);
                    break;
                }
            }
        }
        return duplicates;
    }

    /**
     * The isMagic function.
     *
     * @param preSquare - the square array to check if it's magic.
     * @return boolean
     */
    public static boolean isMagic(final int[] preSquare) {
        // returns true or false for whether or not array is a magic square
        final int row1 = preSquare[0] + preSquare[1] + preSquare[2];
        final int row2 = preSquare[THREE] + preSquare[FOUR] + preSquare[FIVE];
        final int row3 = preSquare[SIX] + preSquare[SEVEN] + preSquare[EIGHT];

        final boolean rows = row1 == MAGICNUM
            && row2 == MAGICNUM && row3 == MAGICNUM;

        final int col1 = preSquare[0] + preSquare[THREE] + preSquare[SIX];
        final int col2 = preSquare[1] + preSquare[FOUR] + preSquare[SEVEN];
        final int col3 = preSquare[2] + preSquare[FIVE] + preSquare[EIGHT];
        final int diag1 = preSquare[0] + preSquare[FOUR] + preSquare[EIGHT];
        final int diag2 = preSquare[2] + preSquare[FOUR] + preSquare[SIX];

        return rows && col1 == MAGICNUM && col2 == MAGICNUM
                && col3 == MAGICNUM && diag1 == MAGICNUM && diag2 == MAGICNUM
                && findDuplicates(preSquare).size() == 0;
    }

    /**
     * The printMagicSquare function.
     *
     * @param outputSquare - the square to be formatted and printed.
     */
    public static void printMagicSquare(final int[] outputSquare) {
        // prints inputted array in a magic square format
        final String space = " ";

        System.out.println('\n');
        for (int count = 0; count < outputSquare.length; count++) {
            if (count == THREE || count == SIX) {
                System.out.println();
                System.out.print(outputSquare[count] + space);
            } else {
                System.out.print(outputSquare[count] + space);
            }
        }
    }

    /**
     * The Main.
     *
     * @param args - No args.
     */
    public static void main(final String[] args) {
        // main stub, get user input here
        final int[] nums = {1, 2, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE};
        final int[] extraArray = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.print("All of the 3x3 Magic Squares:");
        magicSquare(nums, extraArray, 0);

        System.out.println("\n\nDone.");
    }
}
