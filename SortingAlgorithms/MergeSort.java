class Main{
    public static void main(String[] args){
        int[] arr = {3, 2, 4, 1, 3};
        mergeSort(arr, 0, arr.length-1);
        for(int num : arr){
            System.out.print(num+" ");
        }
        System.out.println();
    }
    public static void mergeSort(int[] arr, int low, int high){

        if(low >= high){
            return;
        }

        int mid = (low+high)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }
    public static void merge(int arr[], int low, int mid, int high){

        int i=low, j=mid+1, k=0;

        int temp[] = new int[high-low+1];

        while(i<=mid && j<=high){
            if(arr[i]<=arr[j])temp[k++]=arr[i++];
            else temp[k++] = arr[j++];
        }
        while(i<=mid)temp[k++]=arr[i++];
        while(j<=high)temp[k++]=arr[j++];

        for(int x=0;x<temp.length;x++){
            arr[low+x]=temp[x];
        }
    }
}