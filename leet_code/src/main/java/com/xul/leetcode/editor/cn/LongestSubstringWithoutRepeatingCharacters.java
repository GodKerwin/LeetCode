//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4257 👎 0


package com.xul.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int lengthOfLongestSubstring(String s) {
            Set<Character> set = new HashSet<>();
            int length = s.length();
            int pointer = -1;
            int max = 0;
            for (int i = 0; i < length; i++) {
                if (i != 0) {
                    set.remove(s.charAt(i - 1));
                }
                while (pointer + 1 < length && !set.contains(s.charAt(pointer + 1))) {
                    set.add(s.charAt(pointer + 1));
                    pointer++;
                }
                max = Math.max(max, pointer - i + 1);
            }
            return max;
        }

//        public int lengthOfLongestSubstring(String s) {
//            if (s == null || s.length() == 0){
//                return 0;
//            }
//            Set<String> collect;
//            String b = s.substring(0, 1);
//            for (int i = 0; i < s.length(); i++) {
//                if (s.length() == i + b.length()) {
//                    break;
//                }
//                String value = s.substring(i, i + b.length() + 1);
//                collect = Stream.of(value.split("")).collect(Collectors.toSet());
//                if (collect.size() == b.length() + 1) {
//                    b = value;
//                    --i;
//                }
//            }
//            return b.length();
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}