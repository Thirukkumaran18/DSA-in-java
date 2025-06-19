
import java.util.ArrayList;

class Main{
    public static void main(String[] args){

        int[] arr= {1, 2, 1};
        int k = 2 ;
        ArrayList<Integer> list = new ArrayList<>();
        allSubsequenceWithSumK(arr, k, 0, list, 0);
    }

    public static void allSubsequenceWithSumK(int[] arr, int k, int ind, ArrayList<Integer> list, int sum){
        if(ind == arr.length){
            if(sum == k){
                System.out.println(list);
            }
            return ;
        }
        list.add(arr[ind]);
        allSubsequenceWithSumK(arr, k, ind+1, list, sum+arr[ind]);
        list.remove(list.size()-1);
        allSubsequenceWithSumK(arr, k, ind+1, list, sum);
    }
}