package sort.quicksort;

/**
 * @author ZYLin
 * @date 2019/7/13
 */
public class QuickSort6 {

    static void quickSort(int[] a, int left, int right) {
        if (a == null || a.length < 1 || left >= right) return;
        int mid = partition(a, left, right);
        quickSort(a, left, mid);
        quickSort(a, mid + 1, right);
    }

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static int partition(int[] a, int left, int right) {
        int mid = left + (right - left) / 2;
        if (a[left] > a[right]) {
            swap(a, left, right);
        }
        if (a[mid] > a[right]) {
            swap(a, mid, right);
        }
        if (a[left] < a[mid]) {
            swap(a, left, mid);
        }
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
        int[] a = new int[]{1, 3, 2, 6, 12, 11, 8, 5};
        quickSort(a, 0, a.length - 1);
        for (int i : a){
            System.out.print(i + " ");
        }
    }
}
