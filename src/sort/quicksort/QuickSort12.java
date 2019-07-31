package sort.quicksort;

import util.SortUtil;

public class QuickSort12 {
    private int partition(int[] a, int left, int right) {
        int mid = left + (right - left) / 2;
        if (a[left] > a[right]) {
            SortUtil.swapInt(a, left, right);
        }
        if (a[mid] > a[right]) {
            SortUtil.swapInt(a, mid, right);
        }
        if (a[left] < a[mid]) {
            SortUtil.swapInt(a, left, mid);
        }
        int pivot = a[left];
        while (left < right) {
            while (left < right && a[right] >= pivot) --right;
            if (left < right) {
                a[left] = a[right];
                ++left;
            }
            while (left < right && a[left] <= pivot) ++left;
            if (left < right) {
                a[right] = a[left];
                --right;
            }
        }
        a[left] = pivot;
        return left;
    }

    private void quickSort(int[] a, int l, int r) {
        if (a == null || a.length <= 1 || l >= r) return;
        int mid = partition(a, l, r);
        quickSort(a, l, mid);
        quickSort(a, mid + 1, r);
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 2, 7, 4, 6, 1, 8, 9, 3};
        new QuickSort12().quickSort(a, 0, a.length - 1);
        for (int k : a) {
            System.out.print(k + " ");
        }
    }
}
