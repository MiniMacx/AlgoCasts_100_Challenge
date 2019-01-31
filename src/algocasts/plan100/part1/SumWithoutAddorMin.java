package algocasts.plan100.part1;

/**
 * No.5
 * 不用+/-求两数之和
 * a^b 模拟不进位计算
 * a&b 得出进位
 * 递归进行直到 a&b 为0
 * @author Lin
 */
public class SumWithoutAddorMin {

    /**
     * 递归求法
     * @param a
     * @param b
     * @return
     */
    private static int sumBinaryCur(int a, int b) {
        return b == 0 ? a : sumBinaryCur(a ^ b, (a & b) << 1);
    }

    private static int sumBinaryIter(int a, int b) {
        int temp;
        while(b != 0) {
            temp = a;
            a ^= b;
            b = (temp &b) <<1;
        }
        return a;
    }

    public static void main(String[] args) {
        int a = 5, b = 7;
        System.out.println(sumBinaryCur(a, b));
        System.out.println(sumBinaryIter(a, b));
    }
}
