import java.util.ArrayList;
import java.util.List;

class Main{
    public static void main(String[] args){
        int arr[] = {2, 3, 6, 7};
        int target = 7;
        System.out.println("All possible combinations are : ");
        System.out.println(combinationSum(arr, target)); 
    }
    public static List<List<Integer>> combinationSum(int[] arr, int target) {
        
        List<List<Integer>> mainList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        helper(mainList, list, arr, target, 0);
        return mainList;
    }
    public static void helper(List<List<Integer>> mainList, List<Integer> list, int[] arr, int target, int ind){

        
        if(target == 0){
            mainList.add(new ArrayList<>(list));
            return;
        }
        
        if(ind == arr.length || target < 0)return;

        list.add(arr[ind]);
        helper(mainList, list, arr, target-arr[ind], ind);

        
        list.remove(list.size()-1);
        helper(mainList, list, arr, target, ind+1);

    }
}