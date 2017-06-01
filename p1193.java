import java.util.*;
import java.io.*;

public class p1193 {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = 0, d = 0,cas = 0, tempx,tempy;
        Coordinate[] xy;
        while(true){
            cas++;
            n = in.nextInt();
            d = in.nextInt();
            if(n==0 && d ==0)
                break;
            xy = new Coordinate[n];
            for(int i = 0; i<n; i++){
                tempx = in.nextInt();
                tempy = in.nextInt();
                xy[i] = new Coordinate(tempx,tempy);
            }
            Arrays.sort(xy, Coordinate.thecom);
            System.out.print("Case "+cas+": ");
            printer.printu(xy,d);
        }
    }
    static class printer{
        static void printu(Coordinate[] xy, int d){
            double x = Integer.MIN_VALUE, y = 0.0;
            int count = 0,count1=0;
            Coordinate temp;
            for(int i = 0; i< xy.length;i++){
                temp = xy[i];
                if( temp.y > d){
                    count = -1;
                    break;
                }
                //System.out.println("val "+Double.toString(Math.pow((x-temp.x),2)+Math.pow((y-temp.y),2)));
                if((Math.pow((x-temp.x),2)+Math.pow((y-temp.y),2) - d*d)>=0){
                    if( (double)temp.x + Math.sqrt(d*d-temp.y*temp.y)<x)
                        x=(double)temp.x + Math.sqrt(d*d-temp.y*temp.y);
                    else {
                        x=(double)temp.x + Math.sqrt(d*d-temp.y*temp.y);
                        //System.out.println("x: " + x + " count: " + count);
                        count++;
                    }
                }
            }
            x= Integer.MAX_VALUE;
            for(int i = xy.length-1; i>-1;i--){
                temp = xy[i];
                if( temp.y > d){
                    count1 = -1;
                    break;
                }
                //System.out.println("val "+Double.toString(Math.pow((x-temp.x),2)+Math.pow((y-temp.y),2) ));
                if((Math.pow((x-temp.x),2)+Math.pow((y-temp.y),2) - d*d)>0){
                    if( (double)temp.x - Math.sqrt(d*d-temp.y*temp.y)>x){
                        x = x=(double)temp.x - Math.sqrt(d*d-temp.y*temp.y);
                    }
                    else {
                        x = x=(double)temp.x - Math.sqrt(d*d-temp.y*temp.y);
                        //System.out.println("x: " + x + " count: " + count1);

                        count1++;
                    }
                }
            }
            System.out.println(Math.min(count,count1));
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

    public static Comparator<Coordinate> thecom = new Comparator<Coordinate>() {
        @Override
        public int compare(Coordinate o1, Coordinate o2) {
            return o1.x-o2.x;
        }
    };
}