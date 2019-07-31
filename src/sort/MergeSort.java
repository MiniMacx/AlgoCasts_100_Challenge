package sort;

import util.SortUtil;

public class MergeSort implements ISort {

    void mergeSort(Comparable[] a, int l, int r) {
        //优化点2：已知在较小序列中使用插排有优势，因此归并到子序列相对小时转为插排
//        if (l >= r) return;
        if (r - l <= 15){
            insertSort(a, l , r);
            return;
        }
        int mid = (l + r) / 2;
        mergeSort(a, l, mid);
        mergeSort(a, mid + 1, r);
        //优化点1：若已有序，则进入下个迭代
        if (a[mid].compareTo(a[mid + 1]) > 0){
            merge(a, l, mid, r);
        }
    }

    /**
     * 自底向上，没有用到数组索引。可以给链表排序
     * @param a
     * @param n
     */
    void mergeSortBU(Comparable[] a, int n){
        for (int sz = 1; sz<=n; sz <<= 1){
            for(int i = 0; i + sz < n; i+= sz + sz){
                merge(a, i, i+sz - 1, Math.min(i + sz + sz -1, n -1));
            }
        }
    }

    void insertSort(Comparable[] a, int l, int r){
        Comparable num;
        int j;
        for (int i = l+1; i <= r; i++){
            num = a[i];
            for (j = i; j>l && a[j-1].compareTo(num) > 0;j--){
                a[j] = a[j-1];
            }
            a[j] = num;
        }
    }

    void merge(Comparable[] a, int l, int mid, int r) {
        Comparable[] aux = new Comparable[r - l + 1];
        for (int i = l; i <= r; i++) {
            aux[i - l] = a[i];
        }
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                a[k] = aux[j - l];
                j++;
            } else if (j > r) {
                a[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(aux[j - l]) < 0) {
                a[k] = aux[i - l];
                i++;
            } else {
                a[k] = aux[j - l];
                j++;
            }
        }
    }

    @Override
    public void sort(Comparable[] a) {
//        mergeSort(a, 0, a.length - 1);
        mergeSortBU(a, a.length);
    }

    public static void main(String[] args) {
        Integer[] integers = SortUtil.genRandomIntegerArray(30, 0, 100);
        SortUtil.testSort("sort.MergeSort", integers);
    }
}
