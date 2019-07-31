package algocasts.plan100.part2;

import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

/**
 * No.20 连个有序数组的中位数
 */
public class MedianSortedArrays {
    private double getMedianSortedNum(int[] a, int[] b){
        int total = a.length + b.length;
        if ((total & 1) == 1){
            return findKthSmallest(a, b, total / 2 + 1);
        }else {
            return (findKthSmallest(a, b, total/2) + findKthSmallest(a, b, total / 2 + 1))
                    / 2;
        }
    }

    public double findKthSmallest(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length, base1 = 0, base2 = 0;
        while (true) {
            if (len1 == 0) return nums2[base2 + k - 1];
            if (len2 == 0) return nums1[base1 + k - 1];
            if (k == 1) return Math.min(nums1[base1], nums2[base2]);
            int i = Math.min(k / 2, len1);
            int j = Math.min(k - i, len2);
            int a = nums1[base1 + i - 1], b = nums2[base2 + j - 1];

            if (i + j == k && a == b) return a;

            if (a <= b) {
                base1 += i;
                len1 -= i;
                k -= i;
            }
            if (a >= b) {
                base2 += j;
                len2 -= j;
                k -= j;
            }
        }
    }
}
