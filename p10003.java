import java.util.*;
import java.io.*;

public class p10003 {
    static int dp[][];
    static int[] ar;
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        while(true){
            int l = in.nextInt();
            if(l==0)
                break;
            int n = in.nextInt();
            ar = new int[n+2];
            ar[0] = 0;
            for(int i=1;i<=n;i++)
                ar[i] = in.nextInt();
            ar[n+1] = l;
            dp = new int[ar.length][ar.length];
            for(int i=0;i<dp.length;i++)
                for(int j=0;j<dp[0].length;j++)
                    dp[i][j] = -1;
            System.out.println("The minimum cutting is "+cost(0, n+1)+".");
        }
    }
    
    static int cost(int left, int right){
        if(dp[left][right]!=-1)
            return dp[left][right];
        
        if(left + 1== right)
            return dp[left][right]=0;
        int temp = Integer.MAX_VALUE;
        for(int i=left+1;i<right;i++){
            temp = Math.min(temp, cost(left, i) + cost(i, right) + ar[right] - ar[left]);
        }
        ArrayList<Interger> ar;
        dp[left][right] = temp;
        return temp;
    }
}