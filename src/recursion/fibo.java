package recursion;

public class fibo {
    static int []f=new int[1000];
    static {
        for (int i = 0; i < f.length; i++) {
            f[i]=-1;
        }

    }
    static int fi(int n){
        if(n<=1){
            f[n]=n;
            return n;
        }else {
            if(f[n-1]==-1){
                f[n-1]=fi(n-1);
            }
            if(f[n-2]==-1){
                f[n-2]=fi(n-2);
            }
        }
        return f[n-2]+f[n-1];
    }
    static int fibo(int n){
        int s=0,a=0,b=1;
        for (int i = 2; i <= n; i++) {
            s=a+b;
         a=b;
         b=s;
        }
        return s;
    }
    public static void main(String[] args) {
        System.out.println(fi(5));
        System.out.println(fibo(4));
    }
}
