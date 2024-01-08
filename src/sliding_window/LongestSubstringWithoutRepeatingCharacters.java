package sliding_window;

/**
 * 3. {@link <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">Longest Substring Without Repeating Characters</a>}
 * <p>
 * Given a string s, find the length of the longest
 * substring
 * without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 **/
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.print(lengthOfLongestSubstring("abcabcbb"));
    }
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            if (!str.contains("" + s.charAt(i))) {
                str += s.charAt(i);
            } else {
                str = str.substring(str.indexOf(s.charAt(i)) + 1) + s.charAt(i);
            }
            max = Math.max(str.length(), max);
        }
        return max;
    }
}
