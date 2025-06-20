
class Main{
    public static void main(String[] args){
        int arr[] = {24, 18, 38,43, 14, 40, 1, 54};
        
        int low = 0 ;
        int high = arr.length-1;

        int res = mergeSort(arr, low, high);
        System.out.println("Total number of inversions is : "+res);
    }
    public static int mergeSort(int[] arr, int low, int high){

        if(low == high){
            return 0;
        }

        int count = 0;
        int mid = (low+high)/2;

        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid+1, high);
        count += merge(arr, low, mid, high);
        return count;
    }
    public static int merge(int arr[], int low, int mid, int high){

        int i = low; int j=mid+1;

        int temp[] = new int[(high-low)+1];int k=0;

        int countInMerge = 0 ;
        while(i<=mid && j<= high){
            if(arr[i] <= arr[j])temp[k++] = arr[i++];
            else{
                countInMerge += (mid-i)+1;
                temp[k++] = arr[j++];
            }
        }

        while(i<=mid)temp[k++]=arr[i++];
        while(j<=high)temp[k++]=arr[j++];

        for(int x=0;x<temp.length;x++){
            arr[low+x] = temp[x];
        }
        return countInMerge;
    }
}

/*

Time complexity : O(Nlogn) => as same as Merge sort
Space complexity : O(N) extra temp array is used

*/