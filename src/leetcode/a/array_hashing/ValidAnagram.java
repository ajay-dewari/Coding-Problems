package leetcode.a.array_hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. Valid Anagram {@link <a href="https://leetcode.com/problems/valid-anagram/description/">Valid Anagram</a>}
 * <p>
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "rat", t = "car"
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 **/
public class ValidAnagram {
    public static void main(String[] args) {
        String a = "anagram", b = "nagaram";
        String a1 = "rat", b1 = "cat";
        System.out.print(isAnagram(a, b));
    }

    public static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        } else {
            Map<Character, Integer> hashOfA = new HashMap<>();
            Map<Character, Integer> hashOfB = new HashMap<>();
            for (int i = 0; i < a.length(); i++) {
                char ch1 = a.charAt(i);
                char ch2 = b.charAt(i);
                hashOfA.put(ch1, hashOfA.getOrDefault(ch1, 0) + 1);
                hashOfB.put(ch2, hashOfB.getOrDefault(ch2, 0) + 1);
            }
            return hashOfA.equals(hashOfB);
        }

    }
}
