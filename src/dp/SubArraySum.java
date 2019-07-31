package dp;

/**
 * 分成两个子数组，它们和的差值最小
 * @author ZYLin
 * @date 2019/7/11
 */
public class SubArraySum {

    public static void main(String[] args) {
        System.out.println(subArrayDp(new int[]{1,20,3,3,20,1}));
    }

    static int subArrayDp(int[] arr){
        int sum = 0;
        for (int i=0; i<arr.length; i++){
            sum += arr[i];
        }
        int temp[][] = new int[arr.length + 1][sum/2 + 1]; // 要多1，因为从[1][1]开始保存数据
        for (int i=0; i<arr.length; i++){
            for (int capacity = 1; capacity <= sum/2; capacity++){
                temp[i+1][capacity] = temp[i][capacity];
                if (arr[i] <= capacity && temp[i][capacity - arr[i]] + arr[i] > temp[i][capacity]){
                    temp[i+1][capacity] = temp[i][capacity-arr[i]] + arr[i];
                }
            }
        }
        return Math.max(temp[arr.length][sum/2], sum - temp[arr.length][sum/2]);
    }

}
