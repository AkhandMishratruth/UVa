import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class p787 {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int[] prod;
        BigInteger temp0, max;
        String st;
        String[] temp, star;
        while (in.hasNext()) {
            st = in.nextLine();
            max = BigInteger.valueOf(-999999);
            star = st.split(" -999999")[0].split(" ");
            System.out.println(Solve.solve(star));
        }
    }

    static class Solve {
        static BigInteger solve(String[] temp) {
            BigInteger max, prod;
            BigInteger[] ar = new BigInteger[temp.length];
            for (int i = 0; i < temp.length; i++) {
                ar[i] = BigInteger.valueOf(Integer.parseInt(temp[i]));
            }
            max = ar[0];
            for (int i = 0; i < ar.length; i++) {
                prod = BigInteger.ONE;
                for (int j = i; j < ar.length; j++) {
                    prod = prod.multiply(ar[j]);
                    if (max.compareTo(prod) < 0)
                        max = prod;
                }
            }
            return max;
        }
    }
}