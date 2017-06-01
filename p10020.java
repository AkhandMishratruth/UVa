import java.util.*;
import java.io.*;

public class p10020{
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int t, m , n, tex,tey, max,min;
        t = in.nextInt();

        ArrayList<Coordinate> xy;
        for(int i = 0; i<t;i++ ) {
            max = Integer.MIN_VALUE; min = Integer.MAX_VALUE;
            xy = new ArrayList<Coordinate>();
            m = in.nextInt();
            while (true) {
                tex = in.nextInt();
                tey = in.nextInt();
                if (tex == 0 && tey == 0)
                    break;
                if (tey > max)
                    max = tey;
                if (tex < min)
                    min = tex;
                xy.add(new Coordinate(tex, tey));
            }
            Coordinate[] xyz = new Coordinate[xy.size()];
            xyz = xy.toArray(xyz);
            if (max < m || min > 0){
                System.out.println("0");
                System.out.println();
            }
            else {
                Arrays.sort(xyz, Coordinate.byY);
                printer.printu(xyz, m);
                if(i!=t-1)
                    System.out.println();
            }
        }
    }
    static class printer{
        static void printu(Coordinate[] xy, int m){
            int j = xy.length-1;
            Coordinate runner, present = new Coordinate(0,0);
            ArrayList<Coordinate> toPrint = new ArrayList<Coordinate>();
            while(present.y < m){
                if(j>-1) {
                    runner = xy[j];
                    if (runner.x <= present.y && runner.y > present.y) {
                        present = runner;
                        toPrint.add(present);
                        //System.out.println(present.x + " " + present.y);
                        j = xy.length;
                    }
                }
                else{
                    //System.out.println("ss");
                    break;
                }
                j--;
            }
            //System.out.println("d "+present.y+"le"+ toPrint.size());
            if(present.y >= m) {
                Coordinate cur;
                System.out.println(toPrint.size());
                Iterator it = toPrint.iterator();
                while (it.hasNext()) {
                    cur = (Coordinate) it.next();
                    System.out.println(cur.x + " " + cur.y);
                }
            }
            else{
                System.out.println("0");
            }
        }
    }
}
class Coordinate{
    int x,y;
    Coordinate(int x1, int y1)
    {
        x=x1;
        y=y1;
    }

    public static Comparator<Coordinate> byY = new Comparator<Coordinate>() {
        @Override
        public int compare(Coordinate o1, Coordinate o2) {
            if(o1.y-o2.y!=0)
                return o1.y-o2.y;
            else
                return o2.x-o1.x;
        }
    };
}