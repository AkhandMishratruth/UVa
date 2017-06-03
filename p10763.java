import java.util.*;
import java.io.*;

public class p10763 {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int n, f, t, maxf = Integer.MIN_VALUE, maxt = Integer.MIN_VALUE;
        TreeMap<Integer,ArrayList<Integer>> gra;
        boolean flag;
        Integer from, to;
        ArrayList<Integer> temp;
        Set keyset;
        while(true){
            flag= false;
            gra = new TreeMap<Integer, ArrayList<Integer>>();
            n = in.nextInt();
            if(n == 0)
                break;
            for(int i = 0;i<n;i++) {
                f = in.nextInt();
                t = in.nextInt();
                if (!gra.containsKey(new Integer(f)))
                    gra.put(f, new ArrayList<Integer>());
                gra.get(f).add(t);

                if (f > maxf)
                    maxf = f;
                if (t > maxt)
                    maxt = t;
            }
            if(maxf!=maxt){
                System.out.println("NO");
                continue;
            }
            keyset = gra.keySet();
            Iterator it1, it = keyset.iterator();
            while(it.hasNext()){
                from = (Integer) it.next();
                temp = gra.get(from);
                it1 = temp.iterator();
                //System.out.print(tem+"--> ");
                while(it1.hasNext()){
                    to = (Integer) it1.next();
                    //System.out.print(gra.get(to)==null);
                    if(gra.get(to)!=null && gra.get(to).contains(from)){
                        it1.remove();
                        gra.get(to).remove(new Integer(from));

                    }
                    else{
                        flag = true;
                        break;
                    }
                }
                if(flag == true)
                    break;
            }
            if(flag == true)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }
}