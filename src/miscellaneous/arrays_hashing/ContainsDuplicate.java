package miscellaneous.arrays_hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * 217. {@link <a href="https://leetcode.com/problems/contains-duplicate/">Contains Duplicate</a>}
 * <p>
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: true
 * Example 2:
 * <p>
 * Input: nums = [1,2,3,4]
 * Output: false
 * Example 3:
 * <p>
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 **/
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] array = {2, 4, 6, 8, 9, 2};
        System.out.print(containsDuplicate(array));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> uniques = new HashSet<>();
        for (int num : nums) {
            if (uniques.contains(num)) {
                return true;
            }
            uniques.add(num);
        }
        return false;
    }
}
