import java.util.*;
import java.io.*;

public class p497 {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        List<Integer> ar;
        int t=in.nextInt(), len = 0, temp, j;
        String st;
        int[] shortest, path;
        while (t-- > -2) {
            len=0;
            ar = new ArrayList<Integer>();
            while (in.hasNext()) {
                st = in.nextLine();
                //System.out.println("a"+st);
                if(st.isEmpty())
                    break;
                ar.add(Integer.parseInt(st));
            }
            if(ar.size()>0) {
                Integer[] arr = ar.toArray(new Integer[ar.size()]);
                shortest = new int[arr.length];
                path = new int[arr.length];
                Arrays.fill(path, -1);
                shortest[0] = 0;
                for (int i = 1; i < arr.length; i++) {
                    if (arr[i] > arr[shortest[len]]) {
                        len++;
                        shortest[len] = i;
                        path[i] = shortest[len - 1];
                    } else if (arr[i] <= arr[shortest[0]])
                        shortest[0] = i;
                    else {
                        temp = Bin.binaryCeil(arr, shortest, arr[i], len);
                        shortest[temp] = i;
                        path[i] = shortest[temp - 1];
                    }
                }
                j = shortest[len];
                len = len + 1;
                System.out.println("Max hits: "+len);
                Stack<Integer> toPrint = new Stack<Integer>();
                while (j != -1) {
                    toPrint.add(arr[j]);
                    j = path[j];
                }
                while (!toPrint.isEmpty())
                    System.out.println(toPrint.pop());
                if(t!=-2)
                    System.out.println();
            }
        }
    }

    static class Bin {
        static int binaryCeil(Integer[] ar, int[] T, int s, int r) {
            int l = 0, m;
            while (r - l > 1) {
                m = (r + l) / 2;
                if (ar[T[m]] > s)
                    r = m;
                else if (ar[T[m]] < s)
                    l = m;
                else
                    return m;
            }
            return r;
        }
    }
}
