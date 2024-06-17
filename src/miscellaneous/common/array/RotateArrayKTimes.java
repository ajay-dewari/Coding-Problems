package miscellaneous.common.array;

/**
 * Given an integer miscellaneous.common.array nums, rotate the miscellaneous.common.array to the right by k steps, where k is non-negative.
 * <p>
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * <p>
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 *
 * @author ajaydewari
 * @since 29th April 2023
 */

public class RotateArrayKTimes {

    public static void main(String[] args) {
        int[] array = {9, 7, 6, 8, 4, 3, 2};
        rotateArrayKTimes(array, 3);
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
    }

    static void rotateArrayKTimes(int[] array, int k) {
        int size = array.length;
        k %= size;
        reverse(array, 0, size-1);
        reverse(array, 0,k - 1);
        reverse(array, k, size - 1);
    }

    private static int[] reverse(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
        return array;
    }
}
