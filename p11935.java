import java.util.*;
import java.io.*;

public class p11935 {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        ArrayList<FuelMaster> main;
        int d, e, t;
        boolean flag_exit = false;
        while(true) {
            main = new ArrayList<FuelMaster>();
            while (true) {
                String line = in.nextLine();
                if (line.contains("Fuel consumption")) {
                    d = Integer.parseInt(line.split(" Fuel consumption ")[0]);
                    t = Integer.parseInt(line.split(" Fuel consumption ")[1]);
                    if(d==0 && t == 0){
                        flag_exit = true;
                        break;
                    }
                    //System.out.println("d "+d+",e "+0+",t "+t);
                    main.add(new FuelMaster(d, 0, t));
                } else if (line.contains("Leak")) {
                    d = Integer.parseInt(line.split(" Leak")[0]);
                    //System.out.println("d "+d+", e "+1);
                    main.add(new FuelMaster(d, 1, -1));
                } else if (line.contains("Gas station")) {
                    d = Integer.parseInt(line.split(" Gas station")[0]);
                    //System.out.println("d "+d+", e "+2);
                    main.add(new FuelMaster(d, 2, -1));
                } else if (line.contains("Mechanic")) {
                    d = Integer.parseInt(line.split(" Mechanic")[0]);
                    //System.out.println("d "+d+", e "+3);
                    main.add(new FuelMaster(d, 3, -1));
                } else if (line.contains("Goal")) {
                    d = Integer.parseInt(line.split(" Goal")[0]);
                    //System.out.println("d "+d+", e "+4);
                    main.add(new FuelMaster(d, 4, -1));
                    break;
                }
            }
            if(flag_exit == true)
                break;
            double mid = 0, low = 0, high = 10000;
            for (int k = 0; k < 50; k++) {
                mid = (high + low) / 2.0;
                boolean temp = solver.solve(main, mid);
                //System.out.println(temp+" low: "+low+" high: "+high);
                if (temp == true)
                    high = mid;
                else
                    low = mid;
            }
            float val = Math.round(mid * 1000) / 1000;
            System.out.printf("%.3f", val);
            System.out.println();
        }
    }
    static class solver{
        static boolean solve(ArrayList<FuelMaster> mai, double tank){
            Iterator it = mai.iterator();
            int distance = 0, leak = 0;
            double perKM = 0, fuel = tank;
            FuelMaster f;
            f = (FuelMaster) it.next();
            perKM = f.temp/100.0;
            while(it.hasNext()){
                f = (FuelMaster) it.next();
                fuel = fuel - (leak + perKM)*(f.dist - distance);
                distance = f.dist;
                if(fuel < 0)
                    return false;
                if(f.event == 0)
                    perKM = f.temp/100.0;
                else if (f.event == 1)
                    leak ++;
                else if (f.event == 2)
                    fuel = tank;
                else if (f.event == 3)
                    leak = 0;
                else if(f.event == 4)
                    return true;
            }
            return true;
        }
    }
}
class FuelMaster{
    int dist, event, temp;
    FuelMaster(int d, int e, int t){
        dist = d;
        event = e;
        temp = t;
    }
}