import java.util.*;
import java.io.*;

public class p10026 {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int o, t = in.nextInt();
        job[] the;
        while(t --> 0) {
            o = in.nextInt();
            the = new job[o];
            for (int j = 0; j < o; j++) {
                the[j] = new job(in.nextInt(), in.nextInt(), j + 1);
            }
            Arrays.sort(the);
            System.out.print(the[0].order);
            for (int j = 1; j < o; j++) {
                System.out.print(" "+the[j].order);
            }
            System.out.println();
            if(t> 0) {
                System.out.println();
            }
        }
    }
}
class job implements Comparable<job>{
    int order;
    double ratio;
    job(int t, int f, int or){
        order = or;
        ratio = (t*1.0)/f;
    }

    public int compareTo(job j) {
        Double j1 = (double) this.ratio;
        Double j2 = (double) j.ratio;

        if(j2.compareTo(j1) != 0) {
            return j1.compareTo(j2);
        } else {
            return this.order - j.order;
        }
    }
}