package sort.quicksort;

import sort.ISort;
import util.SortUtil;

public class QuickSort8 implements ISort {

    private void quickSort(Double[] a, int left, int right){
        if (a == null || a.length <=1 || left>=right) return;
        int mid = partition(a, left, right);
        quickSort(a, left, mid);
        quickSort(a, mid + 1, right);
    }


    private void swap(Double[] a, int i, int j){
        Double temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private int partition(Double[] a, int left, int right){
        int mid = left + (right - left) / 2;
        if (a[left] > a[right]){
            swap(a, left, right);
        }
        if (a[mid] > a[right]) {
            swap(a, mid, right);
        }
        if (a[left] < a[mid]){
            swap(a, left, mid);
        }
        double pivot = a[left];
        while (left < right) {
            while (left < right && pivot <= a[right]) --right;
            if (left < right){
                a[left] = a[right];
                ++left;
            }
            while (left < right && pivot >= a[left]) ++ left;
            if (left < right){
                a[right] = a[left];
                --right;
            }
        }
        a[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        Double[] doubles = SortUtil.genDoubleArray(33000);
        SortUtil.testSort("sort.quicksort.QuickSort8", doubles);
    }

    @Override
    public void sort(Comparable[] a) {
        quickSort((Double[]) a, 0, a.length - 1);
    }
}
