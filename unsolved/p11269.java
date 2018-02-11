import java.awt.geom.Arc2D;
import java.util.*;
import java.io.*;

public class p11269 {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int n, t1=0,t2=0;
        Problem[] pro;
        while(in.hasNext()){
            t1 = 0; t2 = 0;
            n = in.nextInt();
            pro = new Problem[n];
            for(int i = 0; i < n; i++)
                pro[i] = new Problem(in.nextInt());
            for(int i = 0; i < n; i++)
                pro[i].g = in.nextInt();

            Arrays.sort(pro, Problem.sor);

            for(int i=0;i<n;i++){
                t1 += pro[i].s;
                t2 -= pro[i].s;
                if(t2<0)
                    t2 = 0;
                t2 += pro[i].g;
                //System.out.println("t1 :"+t1+"t2 :"+t2);
            }
            System.out.println(t1+t2);
        }
    }
}
class Problem{
    int s, g;
    Problem(int sul){
        s = sul;
    }
    public static Comparator<Problem> sor = new Comparator<Problem>() {
        @Override
        public int compare(Problem o1, Problem o2) {
            return Double.compare(o1.s*1.0,o2.s*1.0);
        }
    };
}