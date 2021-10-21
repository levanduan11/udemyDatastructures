package Array;

import java.awt.*;
import java.util.ArrayList;

public class lesson2 {
    public static void main(String[] args) {
ArrayList<Integer>f=new ArrayList<>();

        int arr[]=new int[4];

        arr[0]=1;
        arr[1]=2;
        arr[2]=3;
        arr[3]=4;
        int narr[]=new int[3];
        System.arraycopy(arr,0,narr,0,2);
        System.arraycopy(arr,2,narr,narr.length-1,1);
        arr=narr;
        for (int s:arr
             ) {
            System.out.println(s);
        }
    }
}
