package common.array;

/**
 * Maximum and minimum of an common.array using minimum number of comparisons
 *
 * @author ajaydewari
 * @since 24th April 2023
 */
public class FindMinMaxInArray {
    public static void main(String[] args) {
        int[] array = {9, 7, 6, 8, 4, 3, 2};
        array = findMinMaxInArray(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
    }

    private static int[] findMinMaxInArray(int[] array) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            max = Math.max(max, array[i]);
            min = Math.min(min, array[i]);
        }
        return new int[]{min, max};
    }
}
