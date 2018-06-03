import java.util.*;

public class p665 {
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int k=0;k<t;k++){
            //in.next();
            int n = in.nextInt();
            int m = in.nextInt();
            boolean[] ar = new boolean[n+1];
            while(m-->0){
                int q = in.nextInt();
                int[] left = new int[q], right = new int[q];

                for(int i=0;i<q;i++)
                    left[i] = in.nextInt();
                for(int i=0;i<q;i++)
                    right[i] = in.nextInt();

                String c = in.next();
                if(c.equals("=")){
                    for(int i=0;i<q;i++)
                        ar[left[i]] = true;
                    for(int i=0;i<q;i++)
                        ar[right[i]] = true;
                }
            }
            int count=0, num=0;
            for(int i=1;i<=n;i++) {
                if(!ar[i]){
                    count++;
                    num = i;
                }
            }
            if(count==1)
                System.out.println(num);
            else
                System.out.println("0");

            if(k!=t-1)
                System.out.println();
        }
    }
}

