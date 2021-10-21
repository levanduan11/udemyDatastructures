package ArrayADT;

public class mergesort{
    public static void main(String[] args) {
        int arr[]={5,-5,-9,0,4,3,2,1,-10,11,12,-11};
        sort(arr,false);
        for (int s:arr
             ) {
            System.out.print(s+"  ");
        }
    }
 private   static void sort(int arr[],int copyarr[],int l,int h,boolean order){
        if(h<=l)return;
        int mid=l+(h-l)/2;
        sort(arr,copyarr,l,mid,order);
        sort(arr,copyarr,mid+1,h,order);
        merge(arr,copyarr,l,mid,h,order);
    }
    static void sort(int arr[],boolean order){
        int ar[]=new int[arr.length];
        sort(arr,ar,0,arr.length-1,order);
    }
  private   static void merge(int arr[],int copyarr[],int l,int mid,int h,boolean order){
        for ( int i=l;i<=h;i++) {
            copyarr[i]=arr[i];
        }

        int i=l,j=mid+1;
        for (int k = l; k <=h ; k++) {
            if(i>mid)
                arr[k]=copyarr[j++];
           else if(j>h)
                arr[k]=copyarr[i++];
           else if(order){
                if(copyarr[i]>copyarr[j])
                    arr[k]=copyarr[j++];
                else
                    arr[k]=copyarr[i++];
            }
           else {
                if(copyarr[i]<copyarr[j])
                    arr[k]=copyarr[j++];
                else
                    arr[k]=copyarr[i++];
            }


        }
    }


}
