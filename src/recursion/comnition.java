package recursion;

public class comnition {
    static int s(int n,int r){
        if(r==0||n==r)return 1;
        int k=s(n-1,r-1);
        int i=s(n-1,r);
        int res=k+i;
        return res;
    }
    public static void main(String[] args) {
        System.out.println(s(4,2));
    }
}
