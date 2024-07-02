package miscellaneous.arrays_hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. Longest Consecutive Sequence. {@link <a href="https://leetcode.com/problems/longest-consecutive-sequence/"></a>}
 * Given an array of integers nums, return the length of the longest consecutive sequence of elements.
 * <p>
 * A consecutive sequence is a sequence of elements in which each element is exactly 1 greater than the previous element.
 * <p>
 * You must write an algorithm that runs in O(n) time.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,20,4,10,3,4,5]
 * <p>
 * Output: 4
 * Explanation: The longest consecutive sequence is [2, 3, 4, 5].
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [0,3,2,5,4,6,1,1]
 * <p>
 * Output: 7
 * Constraints:
 * <p>
 * 0 <= nums.length <= 1000
 * -10^9 <= nums[i] <= 10^9
 */
public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] input = {100, 4, 200, 1, 3, 2};
        // int[] input = {1, 2, 2, 3, 3, 3};
        System.out.print(longestConsecutive(input));
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> items = new HashSet<>();
        int maxConsecutiveSize = 0;
        for (int n : nums) {
            items.add(n);
        }

        for (int n : nums) {
            int count = 1;
            int currentItem = n;
            if (!items.contains(currentItem - 1)) {
                while (items.contains(currentItem + 1)) {
                    currentItem++;
                    count++;
                }
                maxConsecutiveSize = Math.max(maxConsecutiveSize, count);
            }
        }
        return maxConsecutiveSize;
    }
}
