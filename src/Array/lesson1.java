package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class lesson1 {
    public static void main(String[] args) {
       HashMap<Integer, Integer>m=new HashMap<>();
        int arr[]={1,2,3,4,5};
        int b[]=arr;
        b[2]=10;
        for (int s:arr
             ) {
            System.out.println(s);
        }
        for (int i = 0; i < arr.length; i++) {
            if(!m.containsKey(arr[i])){
                m.put(arr[i],1);
            }else {
                m.put(arr[i],m.get(arr[i])+1);
            }

        }


    }
}
