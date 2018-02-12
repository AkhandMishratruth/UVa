import java.io.*;
import java.util.*;

public class p10131 {    

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int i = 1;
        ArrayList<Elephant> ar = new ArrayList<>();
        while(in.hasNext()){
            ar.add(new Elephant(in.nextInt(), in.nextInt(), i));
            i++;
        }
        int n = ar.size();
        Collections.sort(ar, Elephant.com);
        int[] lis = new int[n];
        int[] aq = new int[n];
        Arrays.fill(lis, 1);
        Arrays.fill(aq, -1);
        int max=1, maxInd=0;
        for(int j=1;j<n;j++){
            for(int k=0;k<j;k++){
                if(lis[j] < lis[k] + 1 && ar.get(k).wt < ar.get(j).wt && ar.get(k).iq > ar.get(j).iq){
                    lis[j] = lis[k] + 1;
                    aq[j] = k;
                    if(max<lis[j]){
                        max = lis[j];
                        maxInd = j;
                    }
                }
            }
        }
        ArrayList<Integer> a = new ArrayList<Integer>();
        while(aq[maxInd]!=-1){
            a.add(ar.get(maxInd).index);
            maxInd = aq[maxInd];
        }
        Collections.reverse(a);
        for(int k=0;k<a.size();k++)
            System.out.println(a.get(k));
    }
}

class Elephant{
    int wt, iq, index;
    
    Elephant(int w, int i, int ind){
        wt = w;
        iq = i;
        index = ind;
    }
    
    static Comparator<Elephant> com = new Comparator<Elephant>() {
        @Override
        public int compare(Elephant o1, Elephant o2) {
            return Integer.compare(o1.wt, o2.wt);
        }
    };
}

