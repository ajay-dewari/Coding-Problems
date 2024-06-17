package miscellaneous.common.array;

/**
 * 11. Container With Most Water
 * <p>
 * You are given an integer miscellaneous.common.array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * <p>
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * <p>
 * Return the maximum amount of water a container can store.
 * <p>
 * Notice that you may not slant the container.
 * <p>
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by miscellaneous.common.array [1,8,6,2,5,4,8,3,7].
 * In this case, the max area of water (blue section) the container can contain is 49.
 * <p>
 * Example 2:
 * <p>
 * Input: height = [1,1]
 * Output: 1
 *
 * @author ajaydewari
 * @since 23rd April 2023
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] array = {9, 7, 6, 8, 4, 3, 2};
        System.out.print("Maximum Area = " + maxArea(array));
    }

    public static int maxArea(int[] height) {
        int size = height.length;
        int left = 0;
        int right = size - 1;
        int maxCapicity = 0;

        while (left < right) {
            int containerHeight = Math.min(height[left], height[right]);
            int containerwidth = right - left;
            maxCapicity = Math.max(maxCapicity, containerHeight * containerwidth);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxCapicity;
    }
}
