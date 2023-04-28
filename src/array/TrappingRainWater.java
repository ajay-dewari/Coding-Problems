package array;

import java.util.PriorityQueue;

/**
 * Maximum and minimum of an array using minimum number of comparisons
 *
 * @author ajaydewari
 * @since 24th April 2023
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] array = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.print(" " + findWaterFilled(array));
    }

    private static int findWaterFilled(int[] height) {
        int block = 0;
        int size = height.length;
        int[] left = new int[size];
        int[] right = new int[size];
        int max = 0;
        for (int i = 0; i < size; i++) {
            max = Math.max(max, height[i]);
            left[i] = max;
        }
        max = 0;
        for (int i = size - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            right[i] = max;
        }
        for (int i = 0; i < size; i++) {
            block += Math.min(left[i], right[i]) - height[i];
        }
        return block;
    }
}
