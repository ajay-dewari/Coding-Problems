package common.array;

import java.util.PriorityQueue;

/**
 * Maximum and minimum of an common.array using minimum number of comparisons
 *
 * @author ajaydewari
 * @since 24th April 2023
 */
public class FindKthMaxNumber {
    public static void main(String[] args) {
        int[] array = {9, 7, 6, 8, 4, 3, 2};
        System.out.print(" " + findKthMaxNumber(array, 3));
    }

    private static int findKthMaxNumber(int[] array, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(array[i]);
        }
        for (int i = k; i < array.length; i++) {
            if (pq.peek() < array[i]) {
                pq.poll();
                pq.add(array[i]);
            }
        }
        return pq.peek();
    }
}
