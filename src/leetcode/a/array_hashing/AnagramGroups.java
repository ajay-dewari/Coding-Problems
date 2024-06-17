package leetcode.a.array_hashing;

import java.util.*;

/**
 * Leetcode 49. Group Anagrams
 *
 * @see <a href="https://leetcode.com/problems/group-anagrams/description/">...</a>
 * Given an array of strings strs, group all anagrams together into sublists. You may return the output in any order.
 * <p>
 * An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.
 * <p>
 * Example 1:
 * <p>
 * Input: strs = ["act","pots","tops","cat","stop","hat"]
 * <p>
 * Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
 * Example 2:
 * <p>
 * Input: strs = ["x"]
 * <p>
 * Output: [["x"]]
 * Example 3:
 * <p>
 * Input: strs = [""]
 * <p>
 * Output: [[""]]
 * Constraints:
 * <p>
 * 1 <= strs.length <= 1000.
 * 0 <= strs[i].length <= 100
 * strs[i] is made up of lowercase English letters.
 **/
public class AnagramGroups {
    public static void main(String[] args) {
        String[] strs1 = {"act", "pots", "tops", "cat", "stop", "hat"};
        String[] strs2 = {"eat", "tea", "tan", "ate", "nat", "bat"};


        List<List<String>> anagramGroups = groupAnagrams(strs1);
        for (List<String> group : anagramGroups) {
            System.out.print(Arrays.toString(group.toArray()));
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> anagramGroups = new HashMap<>();
        for (String str : strs) {
            Map<Character, Integer> frequencyMap = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                char currentChar = str.charAt(i);
                frequencyMap.put(currentChar, frequencyMap.getOrDefault(currentChar, 0) + 1);
            }
            if (anagramGroups.containsKey(frequencyMap)) {
                anagramGroups.get(frequencyMap).add(str);
            } else {
                List<String> anagramList = new ArrayList<>();
                anagramList.add(str);
                anagramGroups.put(frequencyMap, anagramList);
            }
        }
        return new ArrayList<>(anagramGroups.values());
    }
}
