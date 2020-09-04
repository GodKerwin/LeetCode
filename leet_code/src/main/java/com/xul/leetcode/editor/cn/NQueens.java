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

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NQueens {

    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> result = new ArrayList<>();
            List<String> solve = new ArrayList<>();


            List<Integer> position = new ArrayList<>(); //每行下的位置
            List<String> notPosition = new ArrayList<>();


            for (int i = 1; i <= n; i++) { //每行
                for (int j = 1; j <= n; j++) { //每列
                    if (!CollectionUtils.isEmpty(notPosition)) {
                        String notStr = notPosition.get(i - 1);
                        if (StringUtils.isNotEmpty(notStr)) {
                            List<String> not = Arrays.stream(notStr.split(",")).collect(Collectors.toList());
                            if (not.contains(j + "")) {
                                continue;
                            }
                        }
                    }
                    position.add(j);
                    if (i == 1) {
                        notPosition.add(j + "");
                    }
                    //判断哪些格子不能下
                    for (int k = i + 1; k <= n; k++) {
                        String line = "";
                        if (i - (k - i) > 0) {
                            line += "," + (i - (k - i));
                        }
                        if (i + (k - i) <= n) {
                            line += "," + (i + (k - i));
                        }
                        if (StringUtils.isNotEmpty(line)) {
                            notPosition.add(line);
                        }
                    }
                }
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}