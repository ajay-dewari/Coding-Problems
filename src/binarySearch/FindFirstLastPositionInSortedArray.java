package binarySearch;

/**
 * 34. {@link <a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/">Find First and Last Position of Element in Sorted Array</a>}
 * <p>
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 * <p>
 * If target is not found in the array, return [-1, -1].
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 * <p>
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums is a non-decreasing array.
 * -109 <= target <= 109
 **/
public class FindFirstLastPositionInSortedArray {

    public static void main(String[] args) {
        int[] array = {5, 7, 7, 8, 8, 10};
        System.out.print("Index = " + searchRange(array, 8));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        if (nums.length == 0) {
            return ans;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        if (nums[start] != target) {
            return ans;
        } else {
            ans[0] = start;
            end = nums.length;
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] > target) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
            ans[1] = end - 1;
        }
        return ans;
    }
}
