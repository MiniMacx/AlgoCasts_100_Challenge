package sort.quicksort;

import util.SortUtil;

public class QucikSortNew {
    private int partition(int[] a, int l, int r){
        int v = a[l];
        int j = l;
        for (int i=l+1; i<=r;i++){
            if (a[i] < v){
                SortUtil.swapInt(a, i, ++j);
            }
        }
        SortUtil.swapInt(a, j, l);
        return j;
    }

    private void quickSort(int[] a, int left, int right){
        if (a == null || a.length < 1 || left>=right) return;
        int mid = partition(a, left, right);
        quickSort(a, left, mid);
        quickSort(a, mid + 1, right);
    }

    public static void main(String[] args) {
        int[] a= new int[]{3,2,1,4};
        new QucikSortNew().quickSort(a, 0, a.length-1);
        for (int k: a){
            System.out.print(k + " ");
        }
    }
}
