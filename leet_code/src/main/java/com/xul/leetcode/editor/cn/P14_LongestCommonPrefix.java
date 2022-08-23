//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 2400 👎 0


package com.xul.leetcode.editor.cn;

/**
 * 最长公共前缀
 *
 * @author Xul
 * @date 2022-08-18 19:37:25
 */
public class P14_LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new P14_LongestCommonPrefix().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }
            int minLen = Integer.MAX_VALUE;
            for (String str : strs) {
                minLen = Math.min(minLen, str.length());
            }
            int low = 0;
            int high = minLen;
            while (low < high) {
                int mid = (high - low + 1) / 2 + low;
                if (matchPrefix(strs, mid)) {
                    low = mid;
                } else {
                    high = mid - 1;
                }
            }
            return strs[0].substring(0, low);
        }

        private boolean matchPrefix(String[] strs, int mid) {
            String prefix = strs[0].substring(0, mid);
            for (String str : strs) {
                if (!str.startsWith(prefix)) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}