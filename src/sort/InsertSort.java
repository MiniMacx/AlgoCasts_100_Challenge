package sort;

import util.SortUtil;

public class InsertSort implements ISort{


    public void insertSort(Comparable[] a){
        for (int i=1; i< a.length;i++){
            for (int j=i; j > 0 && a[j].compareTo(a[j-1]) < 0 ; j--){
                SortUtil.swapComparable(a, j-1, j);
            }
        }
    }

    public void newInsertSort(Comparable[] a){
        Comparable k;
        for (int i=1;i<a.length;i++){
            k = a[i];
            int j;
            for (j=i; j>0 && k.compareTo(a[j-1]) < 0; j--){
                    a[j] = a[j - 1];
            }
            a[j] = k;
        }
    }

    public static void main(String[] args) {
//        Integer[] a = SortUtil.genRandomIntegerArray(20000, 0, 214748);
        Integer[] a = SortUtil.genNearlyOrderedArray(20000, 0);
        SortUtil.testSort("sort.SelectionSort", a.clone());
        SortUtil.testSort("sort.InsertSort", a.clone());
    }

    @Override
    public void sort(Comparable[] a) {
        insertSort(a);
    }
}
