import java.util.*;
import java.io.*;

public class p806 {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int max = Integer.MIN_VALUE, sum = 0, i;
        int[][] ar;
        ArrayList<String> arst;
        String st;
        int t = in.nextInt();
        while (t-- > -1) {
            arst = new ArrayList<String>();
            while (true) {
                st = in.nextLine();
                if (st.isEmpty())
                    break;
                arst.add(st);
            }
            max = Integer.MIN_VALUE;
            if (arst.size() > 0) {
                ar = new int[arst.size()][arst.get(0).length()];
                Iterator it = arst.iterator();
                i = 0;
                while (it.hasNext()) {
                    st = (String) it.next();

                    for (int j = 0; j < st.length(); j++)
                        ar[i][j] = Integer.parseInt(Character.toString(st.charAt(j)));
                    i++;
                }

                for (i = 0; i < ar.length; i++) {
                    for (int j = 0; j < ar.length; j++) {
                        if (i > 0) ar[i][j] += ar[i - 1][j];
                        if (j > 0) ar[i][j] += ar[i][j - 1];
                        if (i > 0 && j > 0) ar[i][j] -= ar[i - 1][j - 1];
                    }
                }
                for (i = 0; i < ar.length; i++)
                    for (int j = 0; j < ar.length; j++)
                        for (int k = i; k < ar.length; k++)
                            for (int l = j; l < ar.length; l++) {
                                sum = ar[k][l];
                                if (i > 0) sum -= ar[i - 1][l];
                                if (j > 0) sum -= ar[k][j - 1];
                                if (i > 0 && j > 0) sum += ar[i - 1][j - 1];
                                if (sum == (k - i + 1) * (l - j + 1) && max < sum)
                                    max = sum;
                            }
                if(max<0)
                    System.out.println("0");
                else
                    System.out.println(max);
                System.out.println();
            }
        }
    }
}