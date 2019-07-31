package algocasts.plan100.part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * No.11 数组的全排列
 *
 *
 */
public class FullPermutation {

    public void permuteRec(List<Integer> nums, int start, List<List<Integer>> result) {
        if (start == nums.size()) {
            result.add(new ArrayList<>(nums));
        }
        else {
            for (int i = start; i<nums.size(); i++) {
                Collections.swap(nums, i, start);
                permuteRec(nums, start + 1, result);
                //回溯一次，使后续迭代能够正确执行
                Collections.swap(nums, i, start);
            }
        }
    }


    public List<List<Integer>> permute(Integer[] nums){
        List<List<Integer>> res = new ArrayList<>();
        permuteRec(Arrays.asList(nums), 0, res);
        return res;
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1,3,5,2};
        List<List<Integer>> result = new FullPermutation().permute(nums);
        result.forEach(e -> {
            e.forEach(System.out::print);
            System.out.println();
        });
    }
}
