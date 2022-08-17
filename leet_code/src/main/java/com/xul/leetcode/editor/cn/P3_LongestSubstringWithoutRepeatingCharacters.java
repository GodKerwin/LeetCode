//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 8000 👎 0


package com.xul.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 无重复字符的最长子串
 *
 * @author Xul
 * @date 2022-08-15 17:12:29
 */
public class P3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new P3_LongestSubstringWithoutRepeatingCharacters().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int begin = 0;
            int end = 0;
            int max = 0;
            List<Character> list = new ArrayList<>();
            while (true) {
                if (end == s.length()) {
                    break;
                }
                char c = s.charAt(end);
                if (!list.contains(c)) {
                    list.add(c);
                    end++;
                    max = max > (end - begin) ? max : (end - begin);
                } else {
                    list.remove(0);
                    begin++;
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}