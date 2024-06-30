package miscellaneous.arrays_hashing;

import java.util.Arrays;

/**
 * 238. Product of Array Except Self. {@link <a href="https://leetcode.com/problems/product-of-array-except-self/description/"></a>}
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * <p>
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 * <p>
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 * <p>
 * Constraints:
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * Solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 **/
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4};
        // int[] input = {1, 2, 2, 3, 3, 3};
        // int[] input = {7, 7};
        System.out.print(Arrays.toString(productExceptSelf(input)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int leftProduct = 1;
        int rightProduct = 1;
        int arraySize = nums.length;
        int[] output = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            output[i] = leftProduct;
            leftProduct *= nums[i];
        }

        for (int i = arraySize - 1; i >= 0; i--) {
            output[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return output;
    }
}
