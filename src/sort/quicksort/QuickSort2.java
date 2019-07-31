package sort.quicksort;

import java.util.stream.Stream;

/**
 * @author ZYLin
 * @date 2019/7/9
 */
public class QuickSort2 {

    static void quickSort(Integer[] a, int left, int right) {
        if (a == null || a.length <= 1 || right <= left) return;
        int mid = partition(a, left, right);
        quickSort(a, left, mid);
        quickSort(a, mid + 1, right);
    }

    static int partition(Integer[] a, int left, int right) {
        int temp = a[left];
        while (left < right) {
            while (left < right && temp <= a[right]) right--;
            if (left < right) {
                a[left] = a[right];
                left++;
            }
            while (left < right && temp >= a[left]) left++;
            if (left < right) {
                a[right] = a[left];
                right--;
            }
        }
        a[left] = temp;
        return left;
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{3, 2, 5, 6, 7, 123, 4, 3, 21, 5, 56, 54, 66};
        quickSort(a, 0, a.length - 1);
        Stream.of(a).forEach(e-> System.out.print(e + "  "));
    }
}
