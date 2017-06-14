import java.util.*;
import java.io.*;

public class p674 {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int[] coins = {1, 5, 10, 25, 50};
        long[] value = new long[7489];
        value[0]=1l;
        for (int i = 0; i < coins.length; i++)
            for (int j = coins[i]; j < value.length; j++)
                value[j] += value[j - coins[i]];
        while(in.hasNext())
            System.out.println(value[in.nextInt()]);
    }
}