package array;

public class ReverseArray {

    public static void main(String[] args) {
        int[] array = {9, 7, 6, 8, 4, 3, 2};
        array = reverseArray(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
    }

    private static int[]  reverseArray(int[]  array) {
        int lastIndex = array.length -1;
        for (int i = 0; i < lastIndex/2; i++) {
            int temp = array[i];
            array[i] = array[lastIndex-i];
            array[lastIndex-i] = temp;
        }
        return array;
    }

}
