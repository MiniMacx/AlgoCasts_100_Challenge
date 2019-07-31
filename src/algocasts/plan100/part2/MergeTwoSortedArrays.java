package algocasts.plan100.part2;

/**
 * No.19 合并两个有序数组
 */
public class MergeTwoSortedArrays {

    private void mergeTwoSortedArrays(int[] a, int m,int[] b, int n){
        int i = m - 1, j = n-1;
        int k = m + n -1;
        while (i >=0 && j >=0){
            if (a[i] < b[j]) a[k--] = b[j--];
            else a[k--] = a[i--];
        }
        while (j >=0) a[k--] = b[j--];
    }

    public static void main(String[] args) {
        int[] a = new int[4];
        a[0] = 2;
        a[1] = 4;
        new MergeTwoSortedArrays().mergeTwoSortedArrays(a, 2, new int[]{1,3}, 2);
        for (int k: a) System.out.print(k + " ");

    }
}
