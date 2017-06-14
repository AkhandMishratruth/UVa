import java.util.*;
import java.io.*;

public class p10130 {
    static int[][] ar;
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt(),n, g,toprint;
        int[][] ar;
        int[] v;
        int[] w;
        while(t-->0) {
            toprint=0;
            n=in.nextInt();
            v=new int[n+1];
            w=new int[n+1];

            for(int i=1;i<v.length;i++){
                v[i]=in.nextInt();
                w[i]=in.nextInt();
            }
            g=in.nextInt();
            for(int i=0;i<g;i++)
                toprint +=Solve.solve(v,w,in.nextInt());
            System.out.println(toprint);
        }
    }
    static class Solve{
        static int solve(int[] v, int[] w, int wt){
             ar = new int[v.length][wt+1];
            for (int i = 1; i < ar.length; i++)
                for (int j = 0; j < ar[0].length; j++) {
                    if (j < w[i])
                        ar[i][j] = ar[i - 1][j];
                    else
                        ar[i][j] = Math.max(ar[i - 1][j], ar[i - 1][j - w[i]] + v[i]);
                }
            return ar[ar.length-1][wt];
        }
    }
}