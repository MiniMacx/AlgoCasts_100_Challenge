package algocasts.plan100.part2;

/**
 * 回文字符串判断
 */
public class PalindromeStr {
    public int palindromeCount(String s){
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        int count =0;
        boolean[][] a = new boolean[n][n];
        for (int i=n - 1; i>= 0 ; i--){
            for (int j = i; j< n; j++){
                if (i == j) a[i][j] = true;
                else if (i + 1 == j) a[i][j] = s.charAt(i) == s.charAt(j);
                else a[i][j] = s.charAt(i) == s.charAt(j) && a[i+1][j-1];
                if (a[i][j]) ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromeStr().palindromeCount("abcdcba"));
    }
}
