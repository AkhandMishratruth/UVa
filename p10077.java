import java.awt.geom.Arc2D;
import java.util.*;
import java.io.*;

public class p10077 {
    public static void main(String args[] ) throws Exception {
        //FastReader in = new FastReader();
        Scanner in = new Scanner(System.in);
        int q1, q2;
        while(true) {
            q1 = in.nextInt();
            q2 = in.nextInt();
            if(q1 ==1 && q2 ==1 )
                break;
            solve.solver(0.0, 1.0, 1.0, 0.0, q1, q2);
            System.out.println();
        }
    }
    static class solve{
        static void solver(double m, double n, double m1, double n1, double q1, double q2){
            double mid = (m+m1)/(n+n1);
            if(q1/q2 < mid) {
                System.out.print("L");
                solve.solver(m, n, (m + m1), (n + n1), q1, q2);
            }
            if(q1/q2 > mid) {
                System.out.print("R");
                solve.solver((m + m1), (n + n1), m1, n1, q1, q2);
            }
        }
    }
}