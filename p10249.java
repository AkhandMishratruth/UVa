import java.util.*;
import java.io.*;

public class p10249 {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int m, n;
        int[] teams;
        table[] tab;
        boolean flag;
        int[][] toprint;
        while (true) {
            flag = false;
            m = in.nextInt();
            n = in.nextInt();
            if (m == 0 && n == 0)
                break;
            tab = new table[n];
            teams = new int[m];
            for (int i = 0; i < m; i++)
                teams[i] = in.nextInt();
            for (int i = 0; i < n; i++)
                tab[i] = new table(i + 1, in.nextInt());

            toprint = new int[m][];
            for (int i = 0; i < m; i++) {
                toprint[i] = new int[teams[i]];
            }
            Arrays.sort(tab);
            for (int i = 0; i < teams.length; i++) {
                if (teams[i] > tab.length) {
                    flag = true;
                    break;
                } else {
                    for (int j = 0; j < teams[i]; j++) {
                        tab[j].num--;
                        if (tab[j].num < 0) {
                            flag = true;
                            break;
                        } else
                            toprint[i][j] = tab[j].index;
                    }
                }
                if (flag == true)
                    break;
            }
            if (flag == true)
                System.out.println("0");
            else {
                System.out.println("1");
                for (int i = 0; i < m; i++) {
                    //Arrays.sort(toprint[i]);
                    for (int j = 0; j < toprint[i].length; j++) {
                        System.out.print(toprint[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
class table implements Comparable<table>{
    int index, num;
    table(int i, int n){
        index =i;
        num = n;
    }

    public int compareTo(table j) {

        if(Integer.compare(this.num, j.num) != 0) {
            return Integer.compare(j.num, this.num);
        } else {
            return j.index-this.index;
        }
    }
}