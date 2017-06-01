import java.util.*;
import java.io.*;

public class p410 {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int c, w, l = 1;
        double avg = 0.0;
        int[] copy, ar;
        ArrayList<obej> mass;
        while (in.hasNext()) {
            avg = 0;
            c = in.nextInt();
            w = in.nextInt();
            ar = new int[c*2];
            copy = new int[w];
            mass = new ArrayList<obej>();
            for (int i = 0; i < 2 * c; i++) {
                if (i >= w)
                    ar[i] = 0;
                else {
                    ar[i] = (in.nextInt());
                    copy[i] = ar[i];
                    avg += ar[i];
                }
            }
            avg/=c;
            Arrays.sort(ar);
            for(int j : ar)
                mass.add(new obej(j));
            System.out.println("Set #"+l);
            System.out.printf("IMBALANCE = %.5f",printer.printu(mass, copy,avg, c));
            System.out.println();
            System.out.println();
            l++;
        }
    }
    static class printer{
        static double printu(ArrayList<obej> mass, int[] copy, double avg,int c){
            int  temp1,temp2;
            int ind,i,l=0,j=0;
            double imp=0.0;
            for(; j< copy.length ; j++){
                i = copy[j];
                ind = mass.indexOf(new obej(i));

                if(ind == -1)
                    continue;
                temp1 = mass.get(ind).val;
                temp2 = mass.get(mass.size()-ind-1).val;
                imp += Math.abs(temp1+temp2-avg);
                mass.remove(new obej(temp1));
                mass.remove(new obej(temp2));

                if(temp1 ==0 || temp2 ==0) {
                    System.out.println(" "+l + ": " + (temp1 == 0 ? temp2 : temp1)); l++;
                }
                else {
                    System.out.println(" "+l + ": " + temp1 + " " + temp2); l++;
                }
            }
            while(j<c){
                imp+=avg;
                System.out.println(" "+j+":");
                j++;
            }
            return imp;
        }
    }
}
class obej{
    int val;
    obej(int v){
        val=v;
    }

    @Override
    public boolean equals(Object obj) {
        obej ob = (obej) obj;
        if(ob.getClass() == this.getClass())
            return this.val == ob.val;
        return false;
    }
}