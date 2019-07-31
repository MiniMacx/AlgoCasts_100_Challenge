package sort;

import util.SortUtil;

public class SelectionSort implements ISort{
    private static void selection(Comparable[] a){
        for (int i=0; i< a.length; i++){
            int minIdx = i;
            for (int j=i+1;j<a.length;j++){
                if (a[minIdx].compareTo(a[j]) > 0) minIdx = j;
            }
            swap(a, i, minIdx);
        }
    }

    private static <T> void swap(T[] a, int i, int j){
        T temp = a[i];
        a[i] =a[j];
        a[j] = temp;
    }

    @Override
    public void sort(Comparable[] a) {
        selection(a);
    }

    public static void main(String[] args) {
        SortUtil.testSort("sort.SelectionSort", Student.genRandomStu(10000));
        SortUtil.testSort("sort.quicksort.QuickSort1", SortUtil.genRandomIntegerArray(10000000, 1, 8989899));
        SortUtil.testSort("sort.quicksort.QuickSort7", SortUtil.genRandomIntegerArray(10000000, 1, 8989899));
    }
}
