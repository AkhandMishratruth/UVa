import java.io.*;
import java.util.*;

public class p11517 {    

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter p = new PrintWriter(System.out);
        int n = in.nextInt();
        int[] dp = new int[10001];
        while(n-->0){
            int price = in.nextInt();
            Arrays.fill(dp, -1);
            dp[0] = 0;
            
            int c = in.nextInt();
            for(int j=0;j<c;j++){
                int coin = in.nextInt();
                for(int i=10000;i>=coin;i--){
                    if(dp[i-coin]>-1 && (dp[i]==-1 || dp[i] > dp[i-coin] + 1))
                        dp[i] = dp[i-coin] + 1;
                }
            }
            for(int ret = price; ret<=10000; ++ret) {                
                if(dp[ret]>-1){
                    p.println(ret + " " + dp[ret]);
                    break;
                }
            }
        }
        p.flush();
        p.close();
    }
    
    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            String x = next();
            StringBuilder sb = new StringBuilder("0");
            double res = 0, f = 1;
            boolean dec = false, neg = false;
            int start = 0;
            if (x.charAt(0) == '-') {
                neg = true;
                start++;
            }
            for (int i = start; i < x.length(); i++)
                if (x.charAt(i) == '.') {
                    res = Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    dec = true;
                } else {
                    sb.append(x.charAt(i));
                    if (dec)
                        f *= 10;
                }
            res += Long.parseLong(sb.toString()) / f;
            return res * (neg ? -1 : 1);
        }

        public boolean ready() throws IOException {
            return br.ready();
        }
    }
}

