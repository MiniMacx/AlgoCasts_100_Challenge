package algocasts.plan100.part2;

/**
 * No.15 丢失的数字
 * 找到数组中少掉的数字
 */
public class LostNum {
    private int getLostNum(int[] a){
        int n = a.length, result = n;
        for (int i=0; i<n;i++) result = result ^ i ^ a[i];
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LostNum().getLostNum(new int[]{0,1,4,3,5,7,6,9,8}));
    }
}
