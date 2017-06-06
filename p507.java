import java.util.*;
import java.io.*;

public class p507 {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int sum = 0, ans = 0, ansi = 0, ansj = 0, curi = 0, r, b = in.nextInt();
        int[] ar;
        for(int l = 0; l<b;l++){
            ans = 0;
            sum = 0;
            ansi = 0;
            ansj = 0;
            curi = 0;
            r = in.nextInt();
            ar = new int[r - 1];
            for (int i = 0; i < ar.length; i++)
                ar[i] = in.nextInt();
            for (int i = 0; i < ar.length; i++) {
                sum += ar[i];
                if (ans < sum) {
                    ans = sum;
                    ansj = i;
                    ansi = curi;
                } else if (ans == sum && i - curi > ansj - ansi) {
                    ans = sum;
                    ansj = i;
                    ansi = curi;
                }
                if (sum < 0) {
                    sum = 0;
                    curi = i + 1;
                }
            }
            if(ans==0)
                System.out.printf("Route %d has no nice parts\n", l+1);
            else {
                ansi += 1;
                ansj += 2;
                System.out.printf("The nicest part of route %d is between stops %d and %d\n", l + 1, ansi, ansj);
            }
        }
    }
}