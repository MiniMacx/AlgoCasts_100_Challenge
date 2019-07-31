package thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ZYLin
 * @date 2019/7/12
 */
public class ThreadPoolDemo {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i< nums.length; i++){

            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }
            map.putIfAbsent(nums[i], i);
        }
        return null;
    }

//    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        for (int i=0; i<10; i++){
//            executorService.execute(() -> System.out.println("balabataa" + Thread.currentThread().getName()));
//        }
//
//        executorService.shutdown();
//    }

    public static void main(String[] args) {
       int[] i = twoSum(new int[]{3,2,4}, 6);
        for (int a :
                i) {
            System.out.println(a);
        }
    }
}
