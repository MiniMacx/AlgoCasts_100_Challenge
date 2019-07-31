package sort.quicksort;

/**
 * @author ZYLin
 * @date 2019/7/10
 */
public class QuickSort3 {

    static void quickSort(int[] arr, int left, int right) {
        if (arr == null || arr.length <=1 || left >= right) return;
        int mid = partition(arr, left, right);
        quickSort(arr, left, mid);
        quickSort(arr, mid + 1, right);
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] =temp;
    }

    static int partition(int [] arr, int left, int right){
        //三数取中
        int mid = left + (right - left) / 2;
        if (arr[left] > arr[right]){
           swap(arr, left, right);
        }
        if (arr[mid] > arr[right]){
            swap(arr, mid, right);
        }
        if (arr[mid] > arr[left]){
            swap(arr, left, mid);
        }
        int pivot = arr[left];
        while(left < right){
            while(left < right && pivot <= arr[right]) right--;
            if (left < right){
                arr[left] = arr[right];
                left++;
            }
            while(left < right && pivot >= arr[left]) left++;
            if (left < right){
                arr[right] = arr[left];
                right--;
            }
        }
        arr[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,54,14,46,37,28,56,34,48};
        quickSort(a, 0, a.length-1);
        for (int i: a){
            System.out.print(i + " ");
        }
    }
}
