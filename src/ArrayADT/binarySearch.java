package ArrayADT;

public class binarySearch {
    static int search(int arr[],int key){
       quicksort.sort(arr,true);
        int res=search(arr,key,0,arr.length-1);
        return res;
    }
    static int search1(int arr[],int v){
        quicksort.sort(arr,true);
        int i,j;
        int k=0,n=arr.length;
        for (i=0,j=arr.length-1;i<n/2&&j>=n/2;) {
            if(arr[k]==v)return k;
         else if(arr[k]<v){
              k=j;
              i++;
          }
          else {
              k=i;
              j--;
          }


        }
        return -1;
    }
    static int search(int arr[],int key,int l,int r){
        if(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]<key)
                return search(arr,key,mid+1,r);
            else if(arr[mid]>key)
                return search(arr,key,l,mid-1);
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int k[]={1,2,3,4,0,7,-3,8,9,10};
        int a[]={3,2,78,-77,-33,-22,33,45,76,0,10,9,8,9,33};
        int x=4;
        System.out.println(search(k,7));
    }
}
