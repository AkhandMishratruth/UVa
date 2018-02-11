/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class p111
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in = new Scanner(System.in);
		String[] sss = in.nextLine().split(" ");
		while(in.hasNext()){
		    int n = Integer.parseInt(sss[0]);
		    String[] st = in.nextLine().split(" ");
        	int[] ord = new int[n];
        	for(int i=0;i<n;i++)
        	    ord[Integer.parseInt(st[i])-1] = i;
        	sss = in.nextLine().split(" ");
        	while(sss.length!=1){
            	int[] stu = new int[n];
            	for(int i=0;i<n;i++)
            	    stu[Integer.parseInt(sss[i])-1] = i;
            	System.out.println(ans(stu, ord));
            	if(in.hasNext())
            	    sss = in.nextLine().split(" ");
            	else
            	    break;
        	}
		}
	}
	static int ans(int[] ar, int[] ord){
	    int[][] dp = new int[ar.length+1][ord.length+1];
	    for(int i=1;i<=ar.length;i++){
	        for(int j=1;j<=ar.length;j++){
	            if(ar[i-1]==ord[j-1])
	                dp[i][j] = dp[i-1][j-1] + 1;
	            else
	                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
	        }
	    }
	    return dp[ar.length][ar.length];
	}
}
