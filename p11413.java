import java.util.*;
import java.io.*;

public class p11413 {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int num_vessel;
        int num_cont, high=0;
        int[] vessel;
        while (in.hasNext()) {
            num_vessel = in.nextInt();
            num_cont = in.nextInt();
            vessel = new int[num_vessel];
            for (int i = 0; i < num_vessel; i++) {
                vessel[i] = in.nextInt();
                high+=vessel[i];
            }
            int mid, best = high+1, low = 0;
            while (high >= low) {
                mid = (high + low) / 2;
                if (solve.possible(mid, vessel, num_cont)) {
                    best = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            System.out.println(best);
        }
    }

    static class solve {
        static boolean possible(int high, int[] ar, int m) {
            int cur = 0;
            int n = 0;
            for (int i : ar) {
                if (i > high)
                    return false;
                if (cur + i > high)
                    cur = 0;
                if (cur == 0)
                    n++;
                cur += i;
                if (n > m)
                    return false;
            }
            return true;
        }
    }
}