package miscellaneous.common.array_manipulation;

/**
 *You are given an miscellaneous.common.array of integers nums, there is a sliding window of size k which is moving from the very left of
 *the miscellaneous.common.array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right
 *by one position.
 *
 *Return the max sliding window.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 *
 *
 *Example 2:
 *
 *Input: nums = [1], k = 1
 * Output: [1]
 **/
public class SlidingWindowMaximum {

    public static void main(String[] arg) {

        int[] array = new int[] {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] solution = maxSlidingWindow(array, k);

        for(int i = 0; i< solution.length; i++) {
            System.out.print(" "+solution[i]);
        }

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] solution = new int[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; i++) {
            solution[i] = getMax(nums, i, i + (k - 1));
        }
        return solution;
    }


    private static int getMax(int[] nums, int start, int end) {
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            max = Math.max(nums[i], max);
        }
        return max;
    }

}
