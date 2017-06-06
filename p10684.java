import java.util.*;
import java.io.*;

public class p10684 {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int sum = 0, ans = 0, r;
        int[] ar;
        while (true) {
            ans = 0;
            sum = 0;
            r = in.nextInt();
            if (r == 0)
                break;
            ar = new int[r];
            for (int i = 0; i < ar.length; i++)
                ar[i] = in.nextInt();
            for (int i = 0; i < ar.length; i++) {
                sum += ar[i];
                if (sum < 0)
                    sum = 0;
                if (ans < sum)
                    ans = sum;
            }
            if (ans == 0)
                System.out.printf("Losing streak.\n");
            else
                System.out.printf("The maximum winning streak is %d.\n", ans);
        }
    }
}