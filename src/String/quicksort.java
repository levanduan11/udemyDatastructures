package String;

public class quicksort{
    public static void main(String[] args) {
        String []a={"bcd","uik","abf","abd","bbh"};
        String[]ss={"znhd","abg","ggjj","okkj","kkf","bbt","aaja","gtr","dmj"};
        sort(ss,0,ss.length-1);
        for (String s:ss
             ) {
            System.out.println(s);
        }

    }
 static int comPareto(String a,String b){
     for (int i = 0; i <a.length()&&i<b.length() ; i++) {
         if(a.charAt(i)!=b.charAt(i))return a.charAt(i)-b.charAt(i);
     }
     return a.length()-b.length();
 }
 static void swap(String[]a,int i,int j){
     String t=a[i];
     a[i]=a[j];
     a[j]=t;
 }
 public static void sort(String arr[]){
        sort(arr,0,arr.length-1);
 }
private static void sort(String arr[],int l,int r){
     if(r<l)return;
    String v=arr[l];
    int i=l+1;
    int j=r;
    do {
        while (i<=j&&comPareto(arr[i],arr[l])<0)i++;
        while (i<=j&&comPareto(arr[j],v)>=0)j--;
        if(i<j){
            swap(arr,i,j);
        }

    }while (i<j);
    swap(arr,l,j);
    sort(arr,l,j-1);
    sort(arr,j+1,r);

}

}
