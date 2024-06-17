package miscellaneous.binarySearch;

/**
 * 704. {@link <a href="https://leetcode.com/problems/binary-search/">Binary Search</a>}
 * <p>
 * Given an array of integers nums which is sorted in ascending order, and an integer target,
 * write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * </p>
 * Example 2:
 * <p>
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 104
 * -104 < nums[i], target < 104
 * All the integers in nums are unique.
 * nums is sorted in ascending order.
 */

public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {2, 4, 6, 8, 9, 12};
        System.out.print("Index = " + search(array, 12));
    }

    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                end = mid - 1;

            } else if (target > nums[mid]) {
                start = mid + 1;
            }
        }
        return -1;
    }

    public int recursiveSearch(int[] nums, int target, int start, int end) {
        int mid = (end - start) / 2 + start;
        if (start > end) {
            return -1;
        } else if (nums[mid] == target) {
            return mid;
        } else if (target > nums[mid]) {
            return recursiveSearch(nums, target, mid + 1, end);
        } else if (target < nums[mid]) {
            return recursiveSearch(nums, target, start, end - 1);
        } else {
            return -1;
        }
    }
}


