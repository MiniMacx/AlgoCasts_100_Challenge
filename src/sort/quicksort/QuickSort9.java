package sort.quicksort;

import util.SortUtil;

public class QuickSort9 {

    static void quickSort(int[] a, int i, int j){
        if (a == null || a.length <= 1 || i >= j) return;
        int mid = partition(a, i, j);
        quickSort(a, i, mid);
        quickSort(a, mid + 1, j);
    }


    static int partition(int[] a, int left, int right){
        int mid = left + (right - left) / 2;
        if (a[left] > a[right]){
            SortUtil.swapInt(a, left, right);
        }
        if (a[mid] > a[right]){
            SortUtil.swapInt(a, mid, right);
        }
        if (a[left] < a[mid]){
            SortUtil.swapInt(a, left, mid);
        }
        int pivot = a[left];
        while (left < right){
            while (left< right && pivot <= a[right]) --right;
            if (left< right){
                a[left] = a[right];
                ++left;
            }
            while (left<right && pivot >= a[left]) ++left;
            if (left < right){
                a[right] = a[left];
                --right;
            }
        }
        a[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3,2,5,7,1,9,8};
        quickSort(a, 0 , a.length - 1);
        for (int i: a){
            System.out.print(i + " ");
        }
    }
}
