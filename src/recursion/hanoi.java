package recursion;

public class hanoi {
    static void s(int n,int b,int a){
        if(n>0){
           s(n-1,b=a,a=b);
            System.out.println(b+"  "+a);
        }
    }
    static void h(int n,int a,int b,int c){
        if(n>0){
            h(n-1,a,c,b);
            System.out.println(a+"-->"+c);
            h(n-1,b,a,c);
        }
    }
    public static void main(String[] args) {
h(3,1,2,3);
//s(10,0,1);
    }
}
/*
A-->C
A-->B
C-->B
A-->C
B-->A
B-->C
A-->C

 */
