package algocasts.plan100.part2;

/**
 * No.13回文数字判断
 *
 */
public class PalindromeNum {

    private boolean isPalindromeNumStr(String s){
        if (s == null || s.length()<1) return false;
        int i=0, j= s.length() - 1;
        while (i < j){
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromeNum().isPalindromeNumStr("13221"));
    }
}
