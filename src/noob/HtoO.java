package noob;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class HtoO {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        String s;
        n = sc.nextInt();
        if (1 <= n && n<= 10){
            String[] a = new String[n];
            for (int i=0; i< a.length; i++) {
                s = sc.next();
                if (s.length() < 100000){
                    a[i] = s;
                }
            }
            hToO(a);
        }
    }

    static void hToO(String[] a) {
        for (String s: a) {
//            byte[] bytes = new byte[s.length()/2];
//            byte high = 0;
//            byte low = 0;
//            for (int i=0; i< s.length() / 2; i++) {
//                high = Byte.parseByte(s.substring(i*2, i*2+1), 16);
//                low = Byte.parseByte(s.substring(i*2+1, i*2+2), 16);
//                bytes[i] = (byte)(high << 4 | low);
//            }
            BigInteger bigInteger = new BigInteger(s);
            System.out.println(bigInteger.toString(8));
//            System.out.println(Integer.toOctalString(Integer.parseInt(s, 16)));
        }
    }
}
