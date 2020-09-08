//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。 
//
// 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。 
//
// 你可以假设 nums1 和 nums2 不会同时为空。 
//
// 
//
// 示例 1: 
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
// 
//
// 示例 2: 
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
// 
// Related Topics 数组 二分查找 分治算法 
// 👍 3147 👎 0


package com.xul.leetcode.editor.cn;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int aLength = nums1.length;
            int bLength = nums2.length;
            int index = (aLength + bLength) / 2 + 1;
            int left = 0;
            int right = 0;
            int aStart = 0;
            int bStart = 0;
            for (int i = 0; i < index; i++) {
                left = right;
                if (bStart < bLength && (aStart >= aLength || nums1[aStart] >= nums2[bStart])) {
                    right = nums2[bStart++];
                } else {
                    right = nums1[aStart++];
                }
            }
            if ((aLength + bLength) % 2 == 0) {
                return (left + right) / 2.0;
            } else {
                return right;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}