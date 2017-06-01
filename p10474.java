import java.awt.geom.Arc2D;
import java.util.*;
import java.io.*;

public class p10474 {
    public static void main(String args[] ) throws Exception {
        //FastReader in = new FastReader();
        Scanner in = new Scanner(System.in);
        int n, q, temp, temp1, l=1;
        while (true) {
            n = in.nextInt();
            q = in.nextInt();
            if(n == 0 && q == 0)
                break;
            System.out.println("CASE# "+l+":");l++;
            int[] ar = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = in.nextInt();
            }
            Arrays.sort(ar);
            for (int i = 0; i < q; i++) {
                temp1 = in.nextInt();
                temp = solve.solver(ar, temp1, 0, ar.length - 1);
                if (temp == -1)
                    System.out.println(temp1 + " not found");
                else
                    System.out.println(temp1 + " found at " + (temp + 1));
            }
        }
    }
    static class solve{
        static int solver(int[] ar, int q, int l, int r){
            int mid = (l+r)/2;
            if(l==r){
                if(ar[mid] == q)
                    return mid;
            }
            if(l<r) {
                if (ar[mid] > q)
                    return solve.solver(ar, q, l, mid);
                if (ar[mid] < q)
                    return solve.solver(ar, q, mid + 1, r);
                if (ar[mid] == q) {
                    if (mid >0 && ar[mid - 1] == q)
                        return solve.solver(ar, q, l, mid);
                    else
                        return mid;
                }
            }
            return -1;
        }
    }
}