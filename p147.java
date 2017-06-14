import java.util.*;
import java.io.*;

public class p147 {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        double temp;
        int[] coins = {5,10,20,50,100,200,500,1000,2000,5000,10000};
        long[] value = new long[30001];
        value[0]=1l;
        for (int i = 0; i < coins.length; i++)
            for (int j = coins[i]; j < value.length; j++)
                value[j] += value[j - coins[i]];
        while(true) {
            temp = in.nextDouble();
            if(temp ==0.00)
                break;
            System.out.printf("%6.2f%17d%n",temp, value[(int)Math.round(temp*100)]);
        }
    }
}