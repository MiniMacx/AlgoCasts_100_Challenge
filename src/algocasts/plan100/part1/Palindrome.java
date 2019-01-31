package algocasts.plan100.part1;

/**
 * No.1 回文字符串判断
 * 忽略大小写
 * @author Lin
 */
public class Palindrome {

    /**
     * 判断是否为有效字符，因为已将字符串全改小写，这里不判断大写字符
     * @param c
     * @return
     */
    private boolean isAlphanumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }

    /**
     * 判断回文字符串方法
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }
        //统一改为小写方便处理
        s = s.toLowerCase();
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (i < j && !isAlphanumeric(s.charAt(i)))
                i++;
            while (i < j && !isAlphanumeric(s.charAt(j)))
                j--;
            if (i < j && !(s.charAt(i) == s.charAt(j)))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "race a E_caR";
        System.out.println(new Palindrome().isPalindrome(s));
    }
}
