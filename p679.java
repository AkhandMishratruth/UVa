//import java.io.BufferedReader;
//import java.io.InputStreamReader;
import java.util.*;
import java.io.*;
public class p679 {
    public static void main(String args[] ) throws Exception {
        FastReader in = new FastReader();
        int depth, ball, current;
        int test = in.nextInt();
        while(true){
            depth = in.nextInt();
            if(depth == -1)
                break;
            ball = in.nextInt();
            System.out.println(solve.solver(0, ball, (int)Math.pow(2,depth)-1)+1);
        }
    }
    static class solve{
        static int solver(int node, int ball, int length){
            int left = 2*node + 1;
            int right = 2*node + 2;
            if(right < length){
                if(ball%2 == 0){
                    return solve.solver(right, ball/2, length);
                }
                else{
                    return solve.solver(left, ball/2 + 1, length);
                }
            }
            else
                return node;
        }
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