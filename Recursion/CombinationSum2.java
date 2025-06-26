import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main{
    public static void main(String[] args){

        int arr[] = {10,1,2,7,6,1,5};
        int target = 8;

        // An element from an array should be choosen only once 

        System.out.println("All possible combinations are : ");
        System.out.println(combinationSum2(arr, target));

    }
    public static List<List<Integer>> combinationSum2(int[] arr, int target) {

        Arrays.sort(arr);

        List<List<Integer>> mainList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        helper(mainList, list, arr, target, 0);
        return mainList;

        /*

        Reason for sorting : 

        if arr= {2, 1, 1} and target is 3
        possible pair is :[[2, 1]] but we will get [[2, 1], [2, 1]] which is included 
        with duplicate 

        so we sort it => {1, 1, 2}
        we are skipping the second '1' so the [1, 2] wont repeat again

        */

    }

     public static void helper(List<List<Integer>> mainList, List<Integer> list, int[] arr, int target, int ind) {

        if (target == 0) {
            mainList.add(new ArrayList<>(list));
            return;
        }

        for (int i = ind; i < arr.length; i++) {
            
            if (i > ind && arr[i] == arr[i - 1]) continue; 
            if (arr[i] > target) break; 

            list.add(arr[i]);
            helper(mainList, list, arr, target - arr[i], i + 1); 
            list.remove(list.size() - 1);
                                                                                
        }

    }
}