import java.util.*;
import java.io.*;

public class p11137 {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int temp;
        int[] coins = {1, 8, 27, 64, 125, 216, 343, 512, 729, 1000, 1331, 1728, 2197, 2744, 3375, 4096, 4913, 5832, 6859, 8000, 9261};
        long[] value = new long[10001];
        value[0] = 1l;
        for (int i = 0; i < coins.length; i++)
            for (int j = coins[i]; j < value.length; j++)
                value[j] += value[j - coins[i]];
        while (in.hasNext())
            System.out.println(value[in.nextInt()]);
    }
}