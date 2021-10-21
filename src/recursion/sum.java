package recursion;

public class sum {
    static int p(int n,int m){
        if(m==0)return 1;
        if(m%2==0)return p(n*n,m/2);
        else return n*p(n*n,(m-1)/2);
    }
    static int pow(int n,int m){
        if(m==0)return 1;
        return pow(n,m-1)*n;
    }
   static int s(int n){
       if(n==0)return 0;
       return s(n-1)+n;
   }
   static int gt(int n){
       if(n==0)return 1;
       return gt(n-1)*n;
   }
    public static void main(String[] args) {
        System.out.println(s(5));
    }
}
