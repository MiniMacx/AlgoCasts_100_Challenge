package algocasts.plan100.part2;

/**
 * 判断数字是否为回文数
 * 1、换str 头尾比较
 * 2、整型  拼反向结果后比较
 * @Author: ZYLin
 * @Date: 19-6-30 下午3:59
 */
public class IsPalindrome {

    private static boolean isPalindromeStr(int x){
        String s = String.valueOf(x);
        int j = s.length() - 1, i = 0;
        while(i < j) {
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    private static boolean isPalindromeNum(int x){
        int y = 0, tmp=x, num;
        while(tmp > 0){
            num = tmp % 10;
            y = y * 10 + num;
            tmp = tmp / 10;
        }
        return y == x;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromeNum(973616379));
        System.out.println(isPalindromeStr(973616379));
    }
}
