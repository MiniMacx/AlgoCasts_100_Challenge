package algocasts.plan100.part2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 数组全排列
 * 想象成把当前数组首位替换成其它位的数，
 * 再对它的子数组也这样做（递归）
 * @Author: ZYLin
 * @Date: 19-6-28 下午8:11
 */
public class Permute {

    private static void permuteRec(List<Integer> nums, int start, List<List<Integer>> result) {
        if (nums.size() == start) {
            result.add(new ArrayList<>(nums));
        }else {
            for (int i = start; i < nums.size(); i++){
                Collections.swap(nums, i, start);
                permuteRec(nums, start + 1, result);
                Collections.swap(nums, i, start);
            }
        }
    }
    // Time: O(n*n!), Space: O(n)
    private static List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        for (int num: nums) list.add(num);

        permuteRec(list, 0, result);
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> permute = permute(new int[]{1, 2, 3, 4,6,7,8,9,9,0});
        permute.forEach(e->{
            e.forEach(System.out::print);
            System.out.println();
        });
    }
}
