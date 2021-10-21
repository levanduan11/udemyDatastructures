package SORTING;

public class shellsort {
static boolean less(int a,int b){
    return a<b;
}
static void  swap(int i,int j,int arr[]){
    int t=arr[i];
    arr[i]=arr[j];
    arr[j]=t;
}
static void sort(int arr[]){
    int n=arr.length;
    for (int gap=n/2;gap>=1;gap=gap/2){
        for (int i =gap; i <n ; i++) {
            for (int j = i; j >=gap&&less(arr[j],arr[j-gap]) ; j=j-gap) {
                swap(j,j-gap,arr);
            }
        }
    }

}
    public static void main(String[] args) {
        int arr[]={9,8,7,6,5,4,3,2,1};
sort(arr);
        for (int s:arr
             ) {
            System.out.println(s);
        }
    }
}
