package sort.quicksort;

import sort.ISort;

/**
 * 因自己的态度问题，每天写一遍快排
 *
 * @author ZYLin
 * @date 2019/7/9
 */
public class QuickSort1 implements ISort {
    static void quickSort(Comparable[] a, int left, int right) {
        if (a == null || a.length <= 1 || left >= right) return;
        int mid = partition(a, left, right);
        quickSort(a, left, mid);
        quickSort(a, mid + 1, right);
    }

    static int partition(Comparable[] a, int left, int right) {
        Comparable temp = a[left];
        while (left < right) {
            while (left < right && temp.compareTo(a[right]) <= 0) --right;
            if (left < right) {
                a[left] = a[right];
                ++left;
            }
            while (left < right && temp.compareTo(a[left]) >=0) ++left;
            if (left < right) {
                a[right] = a[left];
                --right;
            }
        }
        a[left] = temp;
        return left;
    }

    @Override
    public void sort(Comparable[] a) {
        quickSort(a, 0, a.length - 1);
    }
}
