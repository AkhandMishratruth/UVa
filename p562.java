import java.util.*;
import java.io.*;

public class p562 {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(), temp, sum, n;
        int[] coins;
        int[][] ar;
        while (t-- > 0) {
            sum = 0;
            n = in.nextInt();
            coins = new int[n];
            for (int i = 0; i < n; i++) {
                temp = in.nextInt();
                coins[i] = temp;
                sum += temp;
            }
            System.out.println(Math.abs(sum - 2 * Coin.coi(coins, sum - sum / 2)));
        }
    }

    static class Coin {
        static int coi(int[] coins, int sum) {
            int[][] ar;
            ar = new int[coins.length + 1][sum + 1];
            for (int i = 1; i < ar.length; i++) {
                for (int j = 1; j < ar[0].length; j++) {
                    if (coins[i - 1] > j)
                        ar[i][j] = ar[i - 1][j];
                    else
                        ar[i][j] = Math.max(ar[i - 1][j], ar[i - 1][j - coins[i - 1]] + coins[i - 1]);
                }
            }
            return (int) Math.ceil(ar[coins.length][sum]);
        }
    }
}