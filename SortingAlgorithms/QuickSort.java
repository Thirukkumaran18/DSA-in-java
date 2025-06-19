
class Main{
    public static void main(String[] args){

        int arr[] = {12, 3, 17, 8, 25, 10, 6, 19};
        int n = arr.length;

        qs(arr, 0, n-1);
        for(int ele : arr){
            System.out.print(ele+" ");
        }
        System.out.println();
        
    }
    public static void qs(int[] arr, int low, int high){
        
        if(low < high){

            int correctIndex = findCorrectIndex(arr, low, high);                    
            qs(arr, low, correctIndex-1);
            qs(arr, correctIndex+1, high);           

        }
    }

    public static int findCorrectIndex(int arr[], int low, int high){

        int i =low ;
        int j = high ;

        int pivot  = arr[low];

        while(i<j){

            while(i<=high && arr[i] <= pivot){
                i++;
            }
            while(j>0 && arr[j] > pivot){
                j--;
            }

            if(i<j){
                int temp = arr[i];
                arr[i] = arr[j] ;
                arr[j] = temp;
            }
        }
        int temp = arr[low] ;
        arr[low] = arr[j] ;
        arr[j] = temp ;

        return j ;
    }
}