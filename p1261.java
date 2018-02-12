import java.io.*;
import java.util.*;

public class p1261 {    

    static HashMap<String, Boolean> set;
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter p = new PrintWriter(System.out);
        set = new HashMap<String, Boolean>();
        int n = in.nextInt();
        while(n-->0){
            String s = in.next();
            p.println((poper(s)?1:0));
        }
        p.flush();
        p.close();
    }
    
    static boolean poper(String s){
        if(s.isEmpty())
            return true;
        if(set.containsKey(s))
            return set.get(s);
        int i=0, l = s.length();
        boolean ans = false;
        while(i<l){
            int j = i + 1;
            while(j<l && s.charAt(i)==s.charAt(j))
                j++;
            if(j>i+1){
                ans = poper(s.substring(0, i) + s.substring(j));
                if(ans)
                    break;
            }
            i = j;
        }
        set.put(s, ans);
        return ans;
    }
}