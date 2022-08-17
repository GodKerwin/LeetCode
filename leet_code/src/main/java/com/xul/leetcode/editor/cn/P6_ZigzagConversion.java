//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下： 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// 
//string convert(string s, int numRows); 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "PAYPALISHIRING", numRows = 3
//输出："PAHNAPLSIIGYIR"
// 
//示例 2：
//
// 
//输入：s = "PAYPALISHIRING", numRows = 4
//输出："PINALSIGYAHRPI"
//解释：
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// 示例 3： 
//
// 
//输入：s = "A", numRows = 1
//输出："A"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由英文字母（小写和大写）、',' 和 '.' 组成 
// 1 <= numRows <= 1000 
// 
// Related Topics 字符串 
// 👍 1766 👎 0


package com.xul.leetcode.editor.cn;

/**
 * Z 字形变换
 *
 * @author Xul
 * @date 2022-08-16 20:32:54
 */
public class P6_ZigzagConversion {
    public static void main(String[] args) {
        Solution solution = new P6_ZigzagConversion().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convert(String s, int numRows) {
            int len = s.length(); //字符串长度
            int row = numRows; //行数
            if (row == 1 || row >= len) {
                return s;
            }
            int t = row + row - 2; //单个循环字符长度
            int perColumn = 1 + row - 2; //单个循环列数
            int n = (len + t - 1) / t; //循环次数
            int column = perColumn * n; //列数
            char[][] chars = new char[row][column]; //定义二维矩阵

            for (int x = 0, y = 0, i = 0; i < len; i++) {
                chars[x][y] = s.charAt(i);
                if (i % t < row - 1) {
                    x++; //下移
                } else {
                    x--; //右上
                    y++;
                }
            }

            StringBuilder result = new StringBuilder();
            for (char[] charColumn : chars) {
                for (char c : charColumn) {
                    if (c != 0) {
                        result.append(c);
                    }
                }
            }

            return result.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}