//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例： 
//
// 输入：4
//输出：[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// Related Topics 回溯算法 
// 👍 568 👎 0


package com.xul.leetcode.editor.cn;

import java.util.*;

public class NQueens {

    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> result = new ArrayList<>();
            int[] queen = new int[n];
            Set<Integer> position = new HashSet<>(); //每行下的位置
            Set<Integer> left = new HashSet<>(); //左侧斜线
            Set<Integer> right = new HashSet<>(); //右侧斜线

            calc(n, 0, queen, position, left, right, result);
            return result;
        }

        public void calc(int n, int row, int[] queen, Set<Integer> position, Set<Integer> left, Set<Integer> right, List<List<String>> result) {
            if (row == n) {
                result.add(geneSolve(queen, n));
            }
            for (int i = 0; i < n; i++) { //每列
                if (position.contains(i)) {
                    continue;
                }
                if (left.contains(row + i)) {
                    continue;
                }
                if (right.contains(row - i)) {
                    continue;
                }
                queen[row] = i;
                position.add(i);
                left.add(row + i);
                right.add(row - i);
                calc(n, row + 1, queen, position, left, right, result);
                queen[row] = -1;
                position.remove(i);
                left.remove(row + i);
                right.remove(row - i);
            }
        }

        public List<String> geneSolve(int[] queen, int n) {
            List<String> solve = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                char[] item = new char[n];
                Arrays.fill(item, '.');
                item[queen[i]] = 'Q';
                solve.add(new String(item));
            }
            return solve;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}