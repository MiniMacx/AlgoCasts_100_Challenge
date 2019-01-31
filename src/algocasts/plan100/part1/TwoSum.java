package algocasts.plan100.part1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * No.2 两数之和
 * @author Lin
 */
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] {0,3,-3,4,-1}, -1)));
    }

    /**
     * 哈希表形式
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int complement;
        for (int i=0;i<nums.length;i++) {
            complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("没有！");
    }
}
