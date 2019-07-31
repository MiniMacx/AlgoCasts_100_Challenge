package util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

public class SortUtil {
    public static Integer[] genRandomIntegerArray(int len, int min, int max){
        Integer[] a = new Integer[len];
        Random random = new Random();
        int i = 0;
        while (i<len){
            a[i] = random.nextInt((max - min) + 1) + min;
            ++i;
        }
        return a;
    }

    public static int[] genRandomIntArray(int len, int min, int max){
        int[] a = new int[len];
        Random random = new Random();
        int i = 0;
        while (i<len){
            a[i] = random.nextInt((max - min) + 1) + min;
            ++i;
        }
        return a;
    }

    public static Integer[] genNearlyOrderedArray(int len, int swapTimes){
        Integer[] a = new Integer[len];
        Random random = new Random();
        int i = 0;
        while (i<len){
            a[i] = i++;
        }
        StringBuilder sb = new StringBuilder("swapped str:");
        while (swapTimes > 0){
            swapComparable(a, random.nextInt(len), random.nextInt(len));
            swapTimes --;
        }
        for (int k: a){
            sb.append(k).append("  ");
        }
        System.out.println(sb.toString());
        return a;
    }

    public static Double[] genDoubleArray(int len){
        Double[] a = new Double[len];
        Random random = new Random();
        int i = 0;
        while (i<len){
            a[i] = random.nextDouble();
            ++i;
        }
        return a;
    }

    public static void testSort(String algName, Comparable[] a){
        try {
            Class sortClz = Class.forName(algName);
            Method m = sortClz.getDeclaredMethod("sort", Comparable[].class);
            long l = System.currentTimeMillis();
            Object[] params = new Object[]{a};
            m.invoke(sortClz.newInstance(), params);
            long end = (System.currentTimeMillis() - l);
            StringBuilder sb = new StringBuilder();
            for (Comparable c : a){
                sb.append(c).append(" ");
            }
            System.out.println(sb.toString());
            assert isSorted(a) : "result error";
            System.out.println(algName + ":" + end);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static void swapInt(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void swapComparable(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static boolean isSorted(Comparable[] a){
        if (a.length < 1) return true;
        for (int i=0; i< a.length - 1; i++){
            if (a[i].compareTo(a[i + 1]) > 0) return false;
        }
        return true;
    }


}
