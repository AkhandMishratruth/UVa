import java.util.*;
import java.io.*;

public class p10670 {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int from,to,agencies, t = in.nextInt();
        int t2 = t;
        String temp1;
        Agencies[] ag;
        char n;
        while(t-->0){
            from = in.nextInt();
            to = in.nextInt();
            agencies = in.nextInt();
            ag = new Agencies[agencies];
            for(int i = 0; i<agencies;i++) {
                temp1 = in.next();
                ag[i] = new Agencies(temp1.split(":")[0], Integer.parseInt(temp1.split(":")[1].split(",")[0])
                        , Integer.parseInt(temp1.split(":")[1].split(",")[1]));
            }
            for(int i = 0; i < ag.length;i++)
                ag[i].costCalculator(from, to);
            Arrays.sort(ag);
            System.out.printf("Case %d\n",t2-t);
            for(Agencies i : ag){
                System.out.println(i.name+" "+i.cost);
            }
        }
    }
}
class Agencies implements Comparable<Agencies>{
    int a, b, cost;
    String name;
    Agencies(String n, int A, int B){
        a = A;
        b = B;
        name = n;
    }

    void costCalculator(int from, int to){
        int temp = from, half=0, less=0;

        while(temp!=to){
            if(temp/2>=to) {
                if ((temp - temp / 2) * a >= b)
                    half++;
                 else
                    less += temp - temp/2;
                temp =temp/2;
            }
            else {
                less += temp - to;
                temp = to;
            }
        }
        cost = less*a+half*b;
    }
    public int compareTo(Agencies j) {

        if(Integer.compare(this.cost, j.cost) != 0) {
            return Integer.compare(this.cost, j.cost);
        } else {
            return this.name.compareTo(j.name);
        }
    }
}