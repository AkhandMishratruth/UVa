import java.util.*;
import java.io.*;

public class p10520 {
    static long dp[][];
    static int n;
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            n = in.nextInt();
            int an1 = in.nextInt();
            dp = new long[n+1][n+1];
            for(int i=0;i<=n;i++)
                for(int j=0;j<=n;j++)
                    dp[i][j] = -1;
            dp[n][1] = an1;
            System.out.println(cost(1, n));
        }
    }
    
    static long cost(int i, int j){
        if(dp[i][j] != -1)
            return dp[i][j];
        if(i<j){
            long temp = 0;
            for(int k=i;k<j;k++)
                temp = Math.max(temp, cost(i, k)+cost(k+1, j));
            dp[i][j] = temp;
            return dp[i][j];
        }
        else{
            long t1;
            if(i==n)
                t1 = 0;
            else{
                t1 = 0;
                for(int k=i+1;k<=n;k++)
                    t1 = Math.max(t1, cost(k, 1)+cost(k, j));
            }
            long t2;
            if(j==0)
                t2 = 0;
            else{
                t2 = 0;
                for(int k=1;k<j;k++)
                    t2 = Math.max(t2, cost(i, k)+cost(n, k));
            }
            dp[i][j] = t1 + t2;
            return dp[i][j];
        }
    }
}