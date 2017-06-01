import java.util.*;
import java.io.*;

public class p12405 {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int n,t = in.nextInt(),cur,count;
        String st;
        char[] ch;
        char temp;
        for(int i = 1; i<=t;i++) {
            count = 0;
            cur  = Integer.MIN_VALUE;
            //System.out.println("Enter n");
            n = in.nextInt();
            //System.out.println("Enter string");
            st = in.next();
            ch = st.toCharArray();
            for(int j = 0; j<ch.length;j++){
                if(ch[j] == '.' && cur+1<j){
                    cur = j+1;
                    //System.out.print(cur+" ");
                    count++;
                }
            }
            System.out.println("Case "+i+": "+count);
        }

    }
}
