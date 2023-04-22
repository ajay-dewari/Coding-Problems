package two_pointer;


import java.util.Arrays;

/**
 * 349. Intersection of Two Arrays
 * <p>
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 * <p>
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Explanation: [4,9] is also accepted.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 **/

public class IntersectionOfTwoArray {
    public static void main(String[] args) {
        int [] arr1 = {5, 2, 8, 11, 2, 9};
        int [] arr2 = {5, 7, 8, 2, 2, 9};

        int [] solution = intersection(arr1, arr2);
        for(int i = 0; i<solution.length; i++) {
            System.out.print(solution[i]);
            System.out.print(" ");
        }

    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = nums1.length;
        int m = nums2.length;
        int i = 0;
        int j = 0;
        int[] solution = new int[Math.min(n, m)];
        int solutionIndex = 0;
        while (1 < n && j < m) {
            if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                solution[solutionIndex] = nums1[i];
                solutionIndex++;
                i++;
                j++;
            }
        }
        return solution;
    }
}
