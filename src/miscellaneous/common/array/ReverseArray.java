package miscellaneous.common.array;

/**
 * Write a program to reverse an miscellaneous.common.array or string
 * <p>
 * Input  : arr[] = {1, 2, 3}
 * Output : arr[] = {3, 2, 1}
 * <p>
 * Input :  arr[] = {4, 5, 1, 2}
 * Output : arr[] = {2, 1, 5, 4}
 *
 * @author ajaydewari
 * @since 23rd April 2023
 */
public class ReverseArray {

    public static void main(String[] args) {
        int[] array = {9, 7, 6, 8, 4, 3, 2};
        array = reverseArray(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
    }

    private static int[] reverseArray(int[] array) {
        int lastIndex = array.length - 1;
        for (int i = 0; i < lastIndex / 2; i++) {
            int temp = array[i];
            array[i] = array[lastIndex - i];
            array[lastIndex - i] = temp;
        }
        return array;
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
