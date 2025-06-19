
import java.util.HashMap;

class Main{
    public static void main(String[] args){

        int[] arr = {-31, -48, -90, 54, 20, 95, 6, -86, 22};
        System.out.println("Maximum length of sub array with sum 0 is : "+maxLen(arr));
    }
    private static int maxLen(int arr[]) {
        
        int maxLen = 0 ;
        int sum =0 ;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int num = arr[i];
            
            sum+= num;
            if(sum == 0){
                maxLen = i+1;
                continue;
            }
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }else{
                int preSumIndex = map.get(sum);
                int currArrSize = i-preSumIndex;
                maxLen = Math.max(maxLen, currArrSize);
            }
        }
        return maxLen;
    }
}

/*

Time complexity = O(nlogn) 
n -> traversing whole array
logn -> iterating the hash map

Space complexity = O(n) => used hash map

*/