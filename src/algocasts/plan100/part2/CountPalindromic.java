package algocasts.plan100.part2;

/**
 * 回文子串个数
 * 1、DP
 * 2、
 * @Author: ZYLin
 * @Date: 19-6-29 下午10:37
 */
public class CountPalindromic {

    // Time: O(n^2), Space: O(n^2)
    private static int countParlindromicSubstringDP(String s){
        if (s == null || s.length() == 0) return 0;
        int n = s.length(), count = 0;
        boolean[][] squ = new boolean[n][n];
        for (int i = n-1; i >= 0; i--){
            for (int j = i; j < n; j++){
                if (i == j) squ[i][j] = true;
                else {
                    boolean b = s.charAt(i) == s.charAt(j);
                    if (i + 1 == j) squ[i][j] = b;
                    else squ[i][j] = b && squ[i+1][j-1];
                }
                if (squ[i][j]) count++;
            }
        }
        return count;
    }

    private static int expand(String s, int left, int right){
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            ++count;
            --left;
            ++right;
        }
        return count;
    }

    private static int countParlindromicSubstringExpand(String s){
        if (s == null || s.length() == 0) return 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            count += expand(s, i, i);
            count += expand(s, i, i + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "aabaa";
        System.out.println(countParlindromicSubstringDP(s) + " " + countParlindromicSubstringExpand(s));
    }
}
