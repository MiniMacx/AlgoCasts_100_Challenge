package sort.quicksort;

/**
 * 三数取中法
 *
 * @author ZYLin
 * @date 2019/7/11
 */
public class QuickSort4 {

    static void qucikSort(int[] a, int left, int right) {
        if (a == null || a.length <= 1 || left >= right) return;
        int mid = partition(a, left, right);
        qucikSort(a, left, mid);
        qucikSort(a, mid + 1, right);
    }

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static int partition(int[] a, int left, int right) {
        int mid = left + (right - left) / 2;
        //确保左值较小
        if (a[left] > a[right]) {
            swap(a, left, right);
        }
        //确保右值较大
        if (a[mid] > a[right]) {
            swap(a, mid, right);
        }
        //确保中值最小
        if (a[mid] > a[left]) {
            swap(a, mid, left);
        }
        //a[left]为中位数，取之
        int pivot = a[left];
        while (left < right) {
            while (left < right && pivot <= a[right]) right--;
            if (left < right) {
                a[left] = a[right];
                left++;
            }
            while (left < right && pivot >= a[left]) left++;
            if (left < right) {
                a[right] = a[left];
                right--;
            }
        }
        a[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        int[] z = new int[]{23, 24, 21, 19, 14, 16, 20};
        qucikSort(z, 0, z.length - 1);
        for (int a :
                z) {
            System.out.print(a + " ");
        }
    }
}
