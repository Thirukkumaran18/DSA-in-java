
import java.util.HashMap;

class Main{
    public static void main(String[] args){
        int arr[] = {4, 2, 2, 6, 4};
        int k = 6;
        int res = countSubArray(arr, k);
        System.out.println("Total number of sub arrays with sum "+k+" is : "+res);
    }
    public static int  countSubArray(int arr[], int k) {
                
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        int sum = 0;
        int count = 0;
        for(int n : arr){
            sum += n;
            
            if(map.containsKey(sum-k)){
                count += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}

/*

Time complexity is O(Nlogn)
 n-> traversing the array one time
 logn => iteration that happens in map

Space complexity is O(N)
 1 extra space used for map

*/