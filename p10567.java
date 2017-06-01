import java.util.*;
import java.io.*;

public class p10567 {
    public static void main(String args[] ) throws Exception {
        //FastReader in = new FastReader();
        Scanner in = new Scanner(System.in);
        String temp, main = in.nextLine();
        //System.out.println(main);
        char[] Ar = main.toCharArray();
        char[] toFind;
        ArrayList<Character> m = new ArrayList<Character>();
        for(char ch : Ar){
            m.add(ch);
        }
        int q = in.nextInt();

        //System.out.println(m.size());
        //System.out.println(m.indexOf(in.next().toCharArray()[0]));

        for(int i = 0; i < q; i++){
            temp = in.nextLine();
            if(temp.trim().length()==0) {
                i--;
                continue;
            }
            //System.out.println(temp);
            toFind = temp.toCharArray();
            solve.solvr(m, toFind);
        }
    }
    static class solve {
        static void solvr(ArrayList main, char[] toFind) {
            int temp, first = 0,l,r;
            first = main.indexOf(toFind[0]);
            if(first == -1) {
                System.out.println("Not matched");
                return;
            }
            l = first;
            r= main.size()-1;
            for(int i = 1; i < toFind.length; i++){
                l = main.indexOf(toFind[i]);
                main.remove(l);
                main.add(l, " ");
                if(l == -1) {
                    System.out.println("Not matched");
                    return;
                }
            }
            System.out.println("Matched "+first+" "+l);
        }
    }
}