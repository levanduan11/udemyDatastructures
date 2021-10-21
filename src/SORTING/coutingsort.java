package SORTING;

public class coutingsort {
    static int findmax(int arr[]){
        int max=arr[0];
        for (int s:arr
             ) {
            max=Math.max(s,max);
        }
        return max;
    }
    static boolean checkNage(int arr[]){
        for (int s:arr
             ) {
            if(s<0)return true;
        }
        return false;
    }
    static void sort(int arr[]){
        if(checkNage(arr)){
            System.err.println("khong the sap xep duoc mang am !!!");
            return;
        }
        int cout[]=new int[findmax(arr)+1];
        for (int i = 0; i < arr.length; i++) {
            cout[arr[i]]++;
        }
        for (int i = 0; i < cout.length-1; i++) {
            cout[i+1]+=cout[i];
        }
        int res[]=new int[arr.length];
        for (int i = arr.length; i-->0 ; ) {
            res[cout[arr[i]]-1]=arr[i];
            cout[arr[i]]--;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i]=res[i];
        }
    }

    public static void main(String[] args) {
        int arr[]={7,7,4,4,-4,3,3,2,1,1,1,0};
        sort(arr);
        for (int s:arr
             ) {
            System.out.print(s+" - ");
        }
    }
}
