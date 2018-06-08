import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.io.*;

class p11340 {
    public static void main(String args[]) throws Exception {
        FastReader in = new FastReader();
        PrintWriter pr = new PrintWriter(System.out);
        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            HashMap<Character, Integer> map = new HashMap<>();
            for(int i = 0; i < n; i++){
                map.put(in.next().charAt(0), in.nextInt());
            }
            int m = in.nextInt();
            long cost = 0;
            for(int i = 0;i<m;i++){
                String s = in.nextLine();
                int l = s.length();
                //System.out.println(i+" "+l);
                //System.out.println(s);
                for(int j=0;j<l;j++){
                    if(map.containsKey(s.charAt(j))){
                        cost += map.get(s.charAt(j));
                    }
                }
            }
            pr.printf("%.2f$\n", (cost/100.0));
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
