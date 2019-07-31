package algocasts.plan100.part3;

/**
 * No 21. 子序列的最大和
 */
public class MaxSumOfSubArray {
    public int getMaxSum(int[] a) {
        int cur = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            cur = cur <= 0 ? a[i] : cur + a[i];
            maxSum = Math.max(cur, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(new MaxSumOfSubArray().getMaxSum(new int[]{1, 2, -1, 3, -5, 1}));

    }
}
