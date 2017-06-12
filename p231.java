import java.util.*;
import java.io.*;

public class p231 {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> ar;
        int[] arr, ar1;
        int t, max, ind = 1;
        while (in.hasNext()) {
            ar = new ArrayList<Integer>();
            while (true) {
                t = in.nextInt();
                if (t == -1)
                    break;
                ar.add(t);
            }
            if (ar.size() > 0) {
                max = 0;
                arr = new int[ar.size()];
                Iterator it = ar.iterator();
                t = ar.size()-1;
                ar1 = new int[arr.length];
                while (it.hasNext()) {
                    arr[t] = (Integer) it.next();
                    ar1[t--] = 1;
                }
                for (int i = 1; i < arr.length; i++)
                    for (int j = 0; j < i; j++) {
                        if (arr[j] <= arr[i] && ar1[j] + 1 > ar1[i])
                            ar1[i] = ar1[j] + 1;
                    }
                for (int i = 0; i < ar1.length; i++)
                    if (max < ar1[i])
                        max = ar1[i];
                if(ind != 1)
                    System.out.printf("\nTest #%d:\n", ind);
                else
                    System.out.printf("Test #%d:\n", ind);
                System.out.println("  maximum possible interceptions: "+ max);
                ind++;
            }
            else
                break;
        }
    }
}