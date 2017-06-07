import java.util.*;
import java.io.*;

public class p108 {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int max = Integer.MIN_VALUE, sum = 0, n;
        int[][] ar;
        while (in.hasNext()) {
            n = in.nextInt();
            ar = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    ar[i][j] = in.nextInt();
                    if (i > 0) ar[i][j] += ar[i - 1][j];
                    if (j > 0) ar[i][j] += ar[i][j - 1];
                    if (i > 0 && j > 0) ar[i][j] -= ar[i - 1][j - 1];
                }
            }
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    for (int k = i; k < n; k++)
                        for (int l = j; l < n; l++) {
                            sum = ar[k][l];
                            if (i > 0) sum -= ar[i - 1][l];
                            if (j > 0) sum -= ar[k][j - 1];
                            if (i > 0 && j > 0) sum += ar[i - 1][j - 1];
                            max = Math.max(max, sum);
                        }
                System.out.println(max);
        }
    }
}