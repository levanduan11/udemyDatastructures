package String;

import java.util.ArrayList;

public class lesson2 {
    static int a[]=new int[3];
    static char b[]=new char[3];
    public static void main(String[] args) {
       char a[]={'a','b','c'};
       p(a,0,0);
    }
    static void print(char[]a){
        for (char s:a
             ) {
            System.out.print(s+"  ");
        }
    }
    static void p(char[]c,int k,int r){
       if(r==c.length){
          print(c);
       }else {
           for (int i = 0; i < c.length; i++) {
               if(a[i]==0){
                   b[k]=c[i];
                   a[i]=1;
                   p(c,k+1,r+1);
                   a[i]=0;
               }
           }
       }
    }
    static void per(char []c,int l,int h){
        if(l==h){
         print(c);
        }else {
            for (int i = l; i <=h ; i++) {
                swap(c,l,i);
                per(c,l+1,h);
                swap(c,l,i);
            }
        }
    }
    static void swap(char []x,int i,int j){
        char k=x[i];
        x[i]=x[j];
        x[j]=k;
    }
    static void d(int n){
        if(n==0)return;
        d(n-1);
        System.out.println(n);
        d(n/2);
    }
}
