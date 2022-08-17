//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 5579 👎 0


package com.xul.leetcode.editor.cn;

/**
 * 最长回文子串
 *
 * @author Xul
 * @date 2022-08-15 20:35:37
 */
public class P5_LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new P5_LongestPalindromicSubstring().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            int length = s.length();
            if (length < 2) {
                return s;
            }
            int max = 1;
            int begin = 0;
            boolean[][] dp = new boolean[length][length];
            for (int i = 0; i < length; i++) {
                dp[i][i] = true;
            }

            char[] chars = s.toCharArray();
            for (int L = 2; L <= length; L++) {
                for (int i = 0; i < length; i++) {
                    int j = i + L - 1;
                    if (j > length - 1) {
                        break;
                    }
                    if (chars[i] != chars[j]) {
                        dp[i][j] = false;
                    } else {
                        if (j - i < 3) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = dp[i + 1][j - 1];
                        }
                    }
                    if (dp[i][j] && j - i + 1 > max) {
                        max = j - i + 1;
                        begin = i;
                    }
                }
            }
            return s.substring(begin, begin + max);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}