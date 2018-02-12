import java.io.*;
import java.util.*;

public class p1196 {    

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        while(true){
            int n = in.nextInt();
            if(n==0)
               break;
            Tile[] ar = new Tile[n];
            for(int i =0;i<n;i++)
                ar[i] = new Tile(in.nextInt(), in.nextInt());
            Arrays.sort(ar, Tile.com);
            int[] lis = new int[n];
            int ans = 1;
            Arrays.fill(lis,1);
            for(int i=1;i<n;i++){
                for(int j=0;j<i;j++){
                    if(lis[i] < lis[j] + 1 && ar[i].left > ar[j].left && ar[i].mid > ar[j].mid)
                        lis[i] = lis[j] + 1;
                }
               ans = Math.max(ans, lis[i]);
            }
            System.out.println(ans);
        }
        System.out.println("*");
    }
    static class Tile{
    int left, mid;
    
    Tile(int l, int m){
        left = l; mid = m;
    }
    
    static Comparator<Tile> com = new Comparator<Tile>() {
        @Override
        public int compare(Tile o1, Tile o2) {
            if(o1.mid==o2.mid && o1.left==o2.left)
                    return 0;
                if(o1.mid>o2.mid && o1.left>o2.left)
                    return 1;
                return -1;
            }
        };
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

