package algocasts.plan100.part1;

/**
 * No.3 有序数组中求和为给定值的两个数
 * 以小->大排序为例，小则小侧进，大则大侧退
 * @author Lin
 */
public class TwoSumInArray {
    private static int[] getTwoSumToGivenValue(int[] array , int sum) {
        int i = 0 , j = array.length -1;
        while (i < j) {
            //比和小，左侧进
            if (array[i] + array[j] < sum){
                ++i;
            }
            //比和大，右侧进
            if (array[i] + array[j] > sum){
                --j;
            }
            //返回位置，各+1
            if (array[i] + array[j] == sum) {
                return new int[]{i+1, j+1};
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] res = getTwoSumToGivenValue(new int[]{1,7,9,13}, 33);
        System.out.println(res[0] + "  " + res[1]);
    }
}
