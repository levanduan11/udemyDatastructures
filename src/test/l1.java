package test;

import java.util.ArrayList;

public class l1 {
    static ArrayList<String>t=new ArrayList<>();
    static void ok(int i,int j,String s){
        if(i==0&&j==0){
            t.add(s);
        }
        if(i>0){
            ok(i-1,j+1,s+"(");
        }
        if(j>0){
            ok(i,j-1,s+")");
        }


    }
    static void ok1(int i,int j,int k,String s){
        if(i==0&&j==0&&k==0){
            t.add(s);
        }
        if(i>0){
            ok1(i-1,j+1,k,s+"(");
        }
        if(j>0){
            ok1(i,j-1,k+1,s+")");
        }
        if(k>0){
            ok1(i,j,k-1,s+")");
        }

    }


    public static void main(String[] args) {
        ok(3,0,"");
    }
}
