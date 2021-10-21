package recursion;

public class taylor {
    static double sums(double n,double x){
        if(n==0)return 1;
        else {
            return sums(n-1,x)*(x/n)+1;
        }
    }
    static double s(double n,double x,double k){
        if(n==0)return k;
       // k=1+x*k/n;
        return s(n-1,x,k=1+x*k/n);
    }
    static void f(int n){
        int k=0;
        if(n==0){
            return;
        }else {
            k+=n;
            System.out.println(k);
            f(n-1);
        }
    }
  static double sumw(double x,double n,double p,double f){
 if(n==0)return 1;
 else {
     return sumw(x,n-1,p=p*x,f=f*n)+(p/f);
 }
   }
    static double sum(int x,int n){
       if(n==0) return 1;

       return sum(x,n-1)+(pow(x,n)/fator(n));
    }
    static double pow(int n,int m){
        if(m==0)return 1;
        if(m%2==0)return pow(n*n,m/2);
        else return n*pow(n*n,(m-1)/2);
    }
    static double fator(int n){
        if(n==0)return 1;
        return fator(n-1)*n;
    }
    public static void main(String[] args) {
        System.out.println(sums(10,1));
        System.out.println(s(4,1,1));
       // System.out.println(sumw(2.0,2.0,1,1));


    }
}
