import java.util.*;
import java.io.*;

public class p437 {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int n, x, y, h, max = 0, cas = 1;
        Block ht;
        Block[] ar;
        int[] hight;
        while (true) {
            n = in.nextInt();
            if (n == 0)
                break;
            ar = new Block[6 * n];
            for (int i = 0; i < 6 * n; i += 6) {
                x = in.nextInt();
                y = in.nextInt();
                h = in.nextInt();
                ar[i] = new Block(x, h, y);
                ar[i + 1] = new Block(x, y, h);
                ar[i + 2] = new Block(y, h, x);
                ar[i + 3] = new Block(h, x, y);
                ar[i + 4] = new Block(y, x, h);
                ar[i + 5] = new Block(h, y, x);
            }
            Arrays.sort(ar);
            ht = ar[0];
            hight = new int[ar.length];
            for (int i = 0; i < ar.length; i++) {
                hight[i] = ar[i].h;
                for (int j = 0; j < i; j++) {
                    if (ar[j].buildable(ar[i])) {
                        hight[i] = Math.max(hight[i], hight[j] + ar[i].h);
                    }
                }
            }
            max = 0;
            for (int i = 0; i < hight.length; i++)
                if (max < hight[i])
                    max = hight[i];
            System.out.println("Case " + cas + ": maximum height = " + max);
            cas++;
        }
    }
}
class Block implements Comparable<Block> {
    int x, y, h;

    Block(int x0, int y0, int h0) {
        x = x0;
        y = y0;
        h = h0;
    }

    @Override
    public int compareTo(Block o) {
        if (this.x != o.x)
            return this.x-o.x;
        else if(this.y!=o.y)
            return(this.y-o.y);
        else
            return(this.h-o.h);
    }

    boolean buildable(Block o) {
        if ((this.x < o.x && this.y < o.y) || (this.y < o.x && this.x < o.y))
            return true;
        else
            return false;
    }
}