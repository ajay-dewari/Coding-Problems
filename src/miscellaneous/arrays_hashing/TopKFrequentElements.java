package miscellaneous.arrays_hashing;

import java.util.*;

/**
 * 217. {@link <a href="https://leetcode.com/problems/top-k-frequent-elements/">Top K Frequent Elements</a>}
 * <p>
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
 **/

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] input = {1, 2, 2, 3, 3, 3};
        int k = 2;
        // int[] input = {7, 7};
        // int k = 1;
        System.out.print(Arrays.toString(topKFrequent(input, k)));
    }

    public static int[] topKFrequent(int[] inputArray, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        Queue<Map.Entry<Integer, Integer>> frequencyQueue = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        int[] outputArray = new int[k];
        int outputArrayIndex = k;
        for (int n : inputArray) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            frequencyQueue.add(entry);
            if (frequencyQueue.size() > k) frequencyQueue.poll();
        }

        while (!frequencyQueue.isEmpty()) {
            outputArray[--outputArrayIndex] = frequencyQueue.poll().getKey();
        }

        return outputArray;
    }
}
