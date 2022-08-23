//给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。 
//
// 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 返回容器可以储存的最大水量。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 2 <= n <= 105 
// 0 <= height[i] <= 104 
// 
// Related Topics 贪心 数组 双指针 
// 👍 3718 👎 0


package com.xul.leetcode.editor.cn;

/**
 * 盛最多水的容器
 *
 * @author Xul
 * @date 2022-08-17 17:52:06
 */
public class P11_ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new P11_ContainerWithMostWater().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int[] height) {
            int max = 0;
            int l = 0;
            int r = height.length - 1;
            while (true) {
                if (l >= r) {
                    break;
                }
                max = Math.max(max, (r - l) * Math.min(height[l], height[r]));
                if (height[l] > height[r]) {
                    r--;
                } else {
                    l++;
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}