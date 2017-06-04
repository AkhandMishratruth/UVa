import java.util.*;
import java.io.*;

public class p11100 {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int n, max,j=0, f;
        int[] bag;
        ArrayList<Integer> bags;
        ArrayList<Integer>[] toprint;
        Set<Integer> theset;
        boolean flag = false;
        Iterator it;
        while(true){
            max = Integer.MIN_VALUE;

            n = in.nextInt();
            if(n==0)
                break;
            bag = new int[n];
            for(int i = 0; i< n;i++)
                bag[i] = in.nextInt();
            Arrays.sort(bag);
            bags = new ArrayList<Integer>();
            for(int i:bag)
                bags.add(new Integer(i));
            theset = new HashSet<Integer>(bags);
            for(Integer i:theset){
                f = Collections.frequency(bags, i);
                if(max < f)
                    max = f;
            }
            System.out.println(max);
            toprint = new ArrayList[max];
            for(int i = 0; i< bags.size(); i++) {
                if (toprint[i % max] == null)
                    toprint[i % max] = new ArrayList<Integer>();
                toprint[i%max].add(bags.get(i));
            }
            for(int i = 0; i<max; j=0, i++){
                it = toprint[i].iterator();
                while(it.hasNext()) {
                    if (j != 0)
                        System.out.print(" ");
                    System.out.print(it.next());
                    j++;
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}