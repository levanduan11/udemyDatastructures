package myProject;

public class test {
    static int []f(int arr[]){
        int []a=new int[arr.length*2];
        System.arraycopy(arr,0,a,0,arr.length);
        return arr=a;
    }
    static void print(int arr[]){
        for (int s:arr
             ) {
            System.out.println(s);
        }
    }
    public static void main(String[] args) {
        int ar[]=new int[5];
        ar[0]=1;
        ar[1]=1;
        ar[2]=1;
        ar[3]=1;
        ar[4]=1;
        ar=f(ar);
        print(ar);
    }
}
