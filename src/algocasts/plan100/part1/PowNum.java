package algocasts.plan100.part1;

/**
 * No.10 数值的 n 次方
 * @author Lin
 */
public class PowNum {

    /**
     * 普通求法，循环相乘，m为负则取倒数
     * Time: O(n), Space: O(1)
     * @param x
     * @param m
     * @return
     */
    public double pow(double x, int m) {
        double result = 1;
        long N = Math.abs((long) m);
        for (int i=0; i<N;i++) {
            result *= x;
        }
        return m > 0 ? result : 1/result;
    }

    /**
     * 快速求法，幂m转为二进制，每个为1的第n位相当于x^(2^n)
     * 如2^11 = 2^8 * 2^2 * 2^1
     * 而(11)B=  1  0  1     1
     * Time: O(log(n)), Space: O(1)
     * @param x
     * @param m
     * @return
     */
    public double powFast(double x, int m) {
        double result = 1;
        long N = Math.abs((long) m);
        while(N != 0) {
            if ((N & 1) == 1) {
                result *= x;
            }
            x *= x;
            N >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        PowNum powNum = new PowNum();
        System.out.println(powNum.powFast(2, 100));
        System.out.println(powNum.pow(2, 100));
    }
}
