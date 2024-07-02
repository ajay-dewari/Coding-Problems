package leetcode.a.array_hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 1. Two Sum
 *
 * @see <a href="https://leetcode.com/problems/two-sum/description/">Two Sum</a>
 * <p>
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 * <p>
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 * <p>
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] array = {2,7,11,15};
        int target = 9;
        int[] input1 = {3,2,4};
        int target1 = 6;
        int[] input2= {3,3};
        int target2 = 6;
        System.out.print( Arrays.toString(twoSum(input2, target2)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexPair = new HashMap<>();

        for (int i =0; i < nums.length; i++) {
            int x = target - nums[i];
            if (indexPair.containsKey(x)) {
                return new int[]{indexPair.get(x), i};
            }
            indexPair.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
