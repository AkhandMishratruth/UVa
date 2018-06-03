import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class p10038 {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int last, cur;
        while (in.hasNext()){
            int n = in.nextInt();
            last = in.nextInt();
            boolean[] flag = new boolean[n];
            for(int i=0;i<n-1;i++) {
                cur = in.nextInt();
                if (Math.abs(cur - last) < n)
                    flag[Math.abs(cur - last)] = true;
                last = cur;
            }
            boolean jolly = true;
            for(int i=1;i<n;i++)
                if(!flag[i])
                    jolly = false;
            if(jolly)
                System.out.println("Jolly");
            else
                System.out.println("Not jolly");
        }
    }
}