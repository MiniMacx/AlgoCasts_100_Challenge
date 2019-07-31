package sort.quicksort;

import util.SortUtil;

public class QuickSort10 {
    static void quickSort(int[] a, int l, int r){
        if (a == null || a.length <1 || l >= r) return;
        int mid = partition(a, l, r);
        quickSort(a, l, mid);
        quickSort(a, mid + 1, r);
    }

    static int partition(int[] a, int l, int r){
        int mid = l + (r - l) /2;
        if (a[l] > a[r]){
            SortUtil.swapInt(a, l ,r);
        }
        if (a[mid] > a[r]){
            SortUtil.swapInt(a, mid, r);
        }
        if (a[l] < a[mid]){
            SortUtil.swapInt(a, l, mid);
        }
        int pivot = a[l];
        while (l < r){
            while (l<r && pivot <= a[r]) r--;
            if (l < r){
                a[l] = a[r];
                l++;
            }
            while (l<r && pivot >= a[l]) l++;
            if (l < r){
                a[r] = a[l];
                r--;
            }
        }
        a[l] = pivot;
        return l;
    }

    public static void main(String[] args) {
        int[] integers = SortUtil.genRandomIntArray(10, 0, 100);
        quickSort(integers, 0 ,integers.length - 1);
        for (int k :
                integers) {
            System.out.print(k + "  ");
        }
    }
}
