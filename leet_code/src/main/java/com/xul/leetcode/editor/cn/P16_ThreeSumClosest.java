//给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。 
//
// 返回这三个数的和。 
//
// 假定每组输入只存在恰好一个解。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0], target = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 1000 
// -1000 <= nums[i] <= 1000 
// -104 <= target <= 104 
// 
// Related Topics 数组 双指针 排序 
// 👍 1220 👎 0


package com.xul.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 最接近的三数之和
 *
 * @author Xul
 * @date 2022-08-23 17:47:40
 */
public class P16_ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new P16_ThreeSumClosest().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int n = nums.length;
            int closest = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (i > 0 && nums[i - 1] == nums[i]) {
                    continue;
                }
                int j = i + 1, k = n - 1;
                while (k > j) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == target) {
                        return sum;
                    }
                    if (Math.abs(sum - target) < Math.abs(closest - target)) {
                        closest = sum;
                    }
                    if (sum > target) {
                        int tempK = k - 1;
                        while (j < tempK && nums[k] == nums[tempK]) {
                            tempK--;
                        }
                        k = tempK;
                    } else {
                        int tempJ = j + 1;
                        while (tempJ < k && nums[j] == nums[tempJ]) {
                            tempJ++;
                        }
                        j = tempJ;
                    }
                }

            }
            return closest;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}