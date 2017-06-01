import java.util.*;
import java.io.*;

public class p957 {
    public static void main(String args[] ) throws Exception {
        //FastReader in = new FastReader();
        Scanner in = new Scanner(System.in);
        int year,pop,pops, startIndx;
        int[] ar;
        while(in.hasNext()) {
            year = in.nextInt();
            pop = in.nextInt();
            ar = new int[pop];
            for (int i = 0; i < pop; i++) {
                ar[i] = in.nextInt();
            }
            pops = Integer.MIN_VALUE;
            startIndx = 0;
            int temp;
            for (int i = 0; i < ar.length; i++) {
                temp = solve.solver(ar, i, ar.length - 1, ar[i] + year - 1);
                temp = temp - i + 1;
                if (temp > pops) {
                    pops = temp;
                    startIndx = i;
                }
            }
            System.out.println(pops + " " + ar[startIndx] + " " + ar[startIndx + pops - 1]);
        }
    }
    static class solve{
        static int solver(int[] ar, int l, int r, int y){
            int mid = (l+r)/2;
            if(l<r){
                if(ar[mid]<y)
                    if(ar[mid+1]>y)
                        return mid;
                    else
                        return solve.solver(ar, mid+1, r, y);
                if(ar[mid]>y)
                    return solve.solver(ar, l, mid, y);
                if(ar[mid]==y && ar[mid+1]==y)
                    return solve.solver(ar, mid+1, r, y);
                else
                    return mid;
            }
            return mid;
        }
    }
}