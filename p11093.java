import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.io.*;

public class p11093 {
    public static void main(String args[]) throws Exception {
        FastReader in = new FastReader();
        PrintWriter pr = new PrintWriter(System.out);
        int t = in.nextInt();
        for (int l = 1; l <= t; l++) {
            int n = in.nextInt();
            int[] p = new int[n];
            int[] q = new int[n];

            for (int i = 0; i < n; i++)
                p[i] = in.nextInt();


            for (int i = 0; i < n; i++)
                q[i] = in.nextInt();

            int sum = 0;
            for (int i = 0; i < n; i++)
                sum += p[i] - q[i];

            if (sum < 0)
                pr.println("Case " + Integer.toString(l) + ": Not possible");
            else {
                boolean found = false;

                for (int i = 0; i < n; i++) {
                    int cur = 0;
                    for (int j = 0; j < n; j++) {
                        cur += p[(i + j) % n];
                        cur -= q[(i + j) % n];
                        if (cur < 0) {
                            break;
                        }
                    }
                    if (cur >= 0) {
                        pr.println("Case " + Integer.toString(l) + ": Possible from station " + Integer.toString(i + 1));
                        found = true;
                        break;
                    }
                }
                if (!found)
                    pr.println("Case " + Integer.toString(l) + ": Not possible");
            }
        }
        pr.flush();
        pr.close();
    }
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}