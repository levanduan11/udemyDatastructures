package recursion;

public class quettion {
 static    void foo (int n, int sum)

    {

        int k = 0, j = 0;

        if (n == 0) return;

        k = n % 10;

        j = n/10;

        sum = sum + k;

        foo (j, sum);

        System.out.println(k);

    }
    static void cout(int n,int d){
        System.out.println(n);
        System.out.println(d);
        d++;
        if(n>1)
            cout(n - 1, d);
        System.out.println(d);

    }
    static int f(int x,int c){
     c=c-1;
     if(c==0)return 1;
     x=x+1;
     return f(x,c)*x;

    }
    static int s(int n){
        int x=1;
        int k;
        if(n==1)return x;
        for ( k = 1; k <n ; k++)
            x=x+s(n)*s(n-k);

        return x;

    }
    public static void main(String[] args) {
        //cout(3,1);
        System.out.println(f(5,5));
        System.out.println(Math.pow(9,4));
    }
}
