import java.util.*;
import java.lang.*;
import java.io.*;

public class p12150
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner in = new Scanner(System.in);
		while(true){
		    int n = in.nextInt();
		    if(n==0)
		        break;
		    int[] car = new int[n];
		    int[] pos = new int[n];
		    for(int i =0;i<n;i++){
		        car[i] = in.nextInt();
		        pos[i] = in.nextInt();
		    }
		    
		    HashMap<Integer, Integer> map = new HashMap<>();
		    boolean flag = false;
		    for(int i=1;i<=n;i++){
                if(i+pos[i-1]>n || i+pos[i-1]<1 || map.containsKey(i+pos[i-1])){
                    flag = true;
                    break;
                }
                map.put(i+pos[i-1], car[i-1]);
		    }
		    if(flag)
		        System.out.println("-1");
		    else{
		        for(Map.Entry ent : map.entrySet())
		        if(!flag){
		            System.out.print(ent.getValue());
		            flag = true;
		        }
		        else
                    System.out.print(" "+ent.getValue());
                    
		        System.out.println();
		    }
		}
	}
}

