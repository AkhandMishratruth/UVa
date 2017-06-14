import java.util.*;
import java.io.*;

public class p357 {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int temp;
        int[] coins = {1, 5, 10, 25, 50};
        long[] value = new long[30001];
        value[0] = 1l;
        for (int i = 0; i < coins.length; i++)
            for (int j = coins[i]; j < value.length; j++)
                value[j] += value[j - coins[i]];
        while (in.hasNext()) {
            temp = in.nextInt();
            if (value[temp] == 1)
                System.out.printf("There is only %d way to produce %d cents change.\n", value[temp], temp);
            else
                System.out.printf("There are %d ways to produce %d cents change.\n", value[temp], temp);
        }
    }
}