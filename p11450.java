import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-->0){
		    int c = in.nextInt(), n = in.nextInt();
		    int[][] ar = new int[n][];
		    for(int i=0;i<n;i++){
		        ar[i] = new int[in.nextInt()];
		        for(int j=0;j<ar[i].length;j++){
		            ar[i][j] = in.nextInt();
		        }
		    }
		    boolean[][] dp = new boolean[n][c+1];
		    for(int i=0;i<ar[0].length;i++){
		        if(c>=ar[0][i])
		            dp[0][c-ar[0][i]] = true;
		    }
		    
		    for(int i=1;i<n;i++){
		        for(int j=0;j<=c;j++){
		            if(dp[i-1][j]){
		                for(int k=0;k<ar[i].length;k++){
		                    if(j>=ar[i][k])
		                        dp[i][j-ar[i][k]] = true;
		                }
		            }
		        }
		    }
		    int i;
		    for(i=0;i<=c;i++){
		        if(dp[n-1][i]){
		            System.out.println(c-i);
		            break;
		        }
		    }
		    if(i==c+1)
		        System.out.println("no solution");
		}
	}
}

