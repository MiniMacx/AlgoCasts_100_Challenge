package sort.quicksort;

import util.SortUtil;

public class QuickSort11 {

    public int partition(int[] a, int left, int right){
        int mid = left + (right - left) / 2;
        if (a[left] > a[right]){
            SortUtil.swapInt(a, left, right);
        }
        if (a[mid] > a[right]){
            SortUtil.swapInt(a, mid, right);
        }
        if (a[left] < a[mid]) {
            SortUtil.swapInt(a, left, mid);
        }
        int pivot = a[left];
        while(left < right){
            while (left < right && pivot <= a[right]) right--;
            if (left<right){
                a[left] = a[right];
                left++;
            }
            while (left<right && pivot >= a[left]) left++;
            if (left < right){
                a[right]  =a[left];
                right--;
            }
        }
        a[left] = pivot;
        return left;
    }

    public void quickSort(int[] a, int left, int right){
        if (a == null || a.length <=1 || left >=right) return;
        int mid = partition(a, left, right);
        quickSort(a, left, mid);
        quickSort(a, mid + 1, right);
    }

    public static void main(String[] args) {
        int[] ints = {1, 4, 2, 3, 6, 5, 9, 7, 8};
        new QuickSort11().quickSort(ints, 0, ints.length - 1);
        for (int k: ints){
            System.out.print(k + " ");
        }
    }
}
