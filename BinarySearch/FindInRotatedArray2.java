class Main {

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        boolean result = search(arr, target);
        if(result){
            System.out.println("Element is found");
        }else{
            System.out.println("Element is not found");
        }
    }

    public static boolean search(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (arr[mid] == target)
                return true;
            
            if(arr[l] == arr[mid] && arr[mid] == arr[r]){
                l=l+1;
                r=r-1;
                continue;
            }

            if (arr[l] <= arr[mid]) {  
                if (arr[l] <= target && target <= arr[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {  
                if (arr[mid] <= target && target <= arr[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return false;
    }
}
