import java.util.ArrayList;
import java.util.List;

class Main{
    public static void main(String[] args){
        int nums[] = {1, 2, 3};
        System.out.println("All possible subsets are : ");
        System.out.println(subsets(nums));
        
    }
    public static List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> mainList = new ArrayList<>();
        
        List<Integer> list = new ArrayList<>();
        
        subsets(mainList, 0, list, nums);
        
        return mainList;
    }
    public static void subsets(List<List<Integer>> mainList, int ind, List<Integer> list, int[] nums){

        mainList.add(new ArrayList<>(list));

        for(int i=ind;i<nums.length;i++){
            list.add(nums[i]);
            subsets(mainList, i+1, list, nums);
            list.remove(list.size()-1);
            
        }
        
    }
}