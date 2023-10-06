package common.array;

/**
 * 42. Trapping Rain Water
 * <p>
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 * <p>
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by common.array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 * <p>
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 *
 * @author ajaydewari
 * @since 28th April 2023
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] array = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.print(" " + findTrappedRainWater(array));
    }

    private static int findTrappedRainWater(int[] height) {
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


    // Solution with linear space complexity
    public int trap(int[] height) {
        int size = height.length;
        int left = 0;
        int right = size - 1;
        int maxLeft = 0;
        int maxRight = 0;
        int res = 0;

        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else {
                    res += maxLeft - height[left];
                }
                left++;
            } else {
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    res += maxRight - height[right];
                }
                right--;
            }
        }
        return res;
    }
}



