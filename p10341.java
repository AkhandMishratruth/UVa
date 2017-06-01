
import java.util.*;
import java.io.*;

public class p10341 {
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        int p,q,r,s,t,u, epoch = 50;
        double e = Math.pow(10,-6);
        function fun;
        double mid=0, le=0.0, ri =1.0;
        while(in.hasNext()) {
            p = in.nextInt();
            q = in.nextInt();
            r = in.nextInt();
            s = in.nextInt();
            t = in.nextInt();
            u = in.nextInt();
            fun = new function(p,q,r,s,t,u);
            if(fun.solver(0)*fun.solver(1)>0){
                System.out.println("No solution");
            }
            else {
                le=0.0; ri =1.0;
                while ((ri - le) > e) {
                    mid = (le + ri) / 2.0;
                    if( fun.solver(mid) * fun.solver(le) <= 0) {
                        ri = mid;
                    }
                    else {
                        le = mid;
                    }
                }
                System.out.printf("%.4f",mid);
                System.out.println();
            }
        }
    }
}
class function{
    int P,Q,R,S,T,U;
    function(int p,int q,int r,int s,int t,int u){
        P = p; Q = q; R = r; S = s; T = t; U = u;
    }
    double solver(double x){
        return P*Math.exp(-x) + Q*Math.sin(x) + R*Math.cos(x) + S*Math.tan(x) + T*x*x + U;
    }
}