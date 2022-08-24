//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b
//], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 
// Related Topics 数组 双指针 排序 
// 👍 1340 👎 0


package com.xul.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 *
 * @author Xul
 * @date 2022-08-24 13:12:56
 */
public class P18_FourSum {
    public static void main(String[] args) {
        Solution solution = new P18_FourSum().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            int n = nums.length;
            for (int a = 0; a < n - 3; a++) {
                if (a > 0 && nums[a - 1] == nums[a]) {
                    continue;
                }
                if ((long) nums[a] + nums[a + 1] + nums[a + 2] + nums[a + 3] > target) {
                    break;
                }
                if ((long) nums[a] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) {
                    continue;
                }
                for (int b = a + 1; b < n - 2; b++) {
                    if (b > a + 1 && nums[b - 1] == nums[b]) {
                        continue;
                    }
                    if ((long) nums[a] + nums[b] + nums[b + 1] + nums[b + 2] > target) {
                        break;
                    }
                    if ((long) nums[a] + nums[b] + nums[n - 1] + nums[n - 2] < target) {
                        continue;
                    }
                    int c = b + 1;
                    int d = n - 1;
                    while (d > c) {
                        int sum = nums[a] + nums[b] + nums[c] + nums[d];
                        if (sum == target) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[a]);
                            list.add(nums[b]);
                            list.add(nums[c]);
                            list.add(nums[d]);
                            result.add(list);
                            while (d > c && nums[c] == nums[c + 1]) {
                                c++;
                            }
                            c++;
                            while (d > c && nums[d] == nums[d - 1]) {
                                d--;
                            }
                            d--;
                        } else if (sum > target) {
                            d--;
                        } else {
                            c++;
                        }
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}