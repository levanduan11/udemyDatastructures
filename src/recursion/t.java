package recursion;

public class t {
    static double ff(double n,double f){
        if(n==0)
            return f;
        return ff(n-1,f=1+1/f);
    }
    static int f(int n,int x,int s){
        if(n==0)return s;
        return f(n-1,x,s=1+x/n*s);
    }
    static int fun(int n){
        int x=1,k;
        if(n==1)return x;
        for ( k = 0; k <n ; k++) {
            x=x+fun(k)*fun(n-k);
        }
        return x;
    }
    static void t(int n,int j){
        String k="kf";
        int s=9;
        if(n==0)return;
       for (int i=0;i<2;i++){


           j++;
           t(n-1,j);
           t(n/2,j);
           System.out.print("  "+i);
       }
    }
    public static void main(String[] args) {
     t(5,0);
    }
}
