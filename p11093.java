import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class p11093 {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int l = 1; l <= t; l++) {
            int n = in.nextInt();
            int[] p = new int[n];
            int[] q = new int[n];

            for (int i = 0; i < n; i++) {
                p[i] = in.nextInt();
                //System.out.print(p[i]+" ");
            }

            //System.out.println();

            for (int i = 0; i < n; i++) {
                q[i] = in.nextInt();
                //System.out.print(q[i]+" ");
            }

            boolean found = false;
            for (int i = 0; i < n; i++) {
                int cur = 0;
                for (int j = 0; j < n; j++) {
                    cur += p[(i + j) % n];
                    cur -= q[(i + j) % n];
                    //System.out.println("cur1 " + Integer.toString(cur));
                    if (cur < 0)
                        break;
                }
                //System.out.println("cur " + Integer.toString(cur));
                if (cur >= 0) {
                    System.out.println("Case " + Integer.toString(l) + ": Possible from station " + Integer.toString(i + 1));
                    found = true;
                    break;
                }
            }
            if (!found)
                System.out.println("Case " + Integer.toString(l) + ": Not possible");
        }
    }
}