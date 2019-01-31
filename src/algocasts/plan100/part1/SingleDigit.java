package algocasts.plan100.part1;

import java.util.HashSet;
import java.util.Set;

/**
 * No.6 单身数字
 * 思路一：哈希集
 * 思路二：异或
 */
public class SingleDigit {
    /**
     * 哈希集求解，得出集合中元素和*2-总和得出单身数字
     * @param nums
     * @return
     */
    private int singleDigitWithSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0, setSum = 0;
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
                setSum += num;
            }
            sum += num;
        }
        return setSum * 2 - sum;
    }

    /**
     * 异或求解，数字相同异或结果为0，全部异或得出唯一数
     * @param nums
     * @return
     */
    private int singleDigitWithXOR(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 2, 3, 3 };
        System.out.println(new SingleDigit().singleDigitWithSet(nums));
        System.out.println(new SingleDigit().singleDigitWithXOR(nums));
    }
}
