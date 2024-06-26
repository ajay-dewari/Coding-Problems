package leetcode.a.array_hashing;

import java.util.*;

/**
 * 347. Top K Frequent Elements
 *
 * @see <a href="https://leetcode.com/problems/top-k-frequent-elements/description/">...</a>
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 * <p>
 * Input: nums = [1], k = 1
 * Output: [1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 * <p>
 * <p>
 * Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] array = {1, 1, 1, 2, 2, 3};
        int[] input = {1,2,2,3,3,3};
        System.out.print(Arrays.toString(topKFrequent(input, 2)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] arr = new int[k];
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> it : countMap.entrySet()) {
            pq.add(it);
            if (pq.size() > k) pq.poll();
        }
        int i = k;
        while (!pq.isEmpty()) {
            arr[--i] = pq.poll().getKey();
        }
        return arr;
    }
}
