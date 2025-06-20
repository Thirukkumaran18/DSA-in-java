import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
       int low = 0;
        int high = nums.length - 1;
        boolean first = true;
        int start = occurrence(nums, low, high, target, first);
        if (start == -1) {
            System.out.println("First occurence : "+-1);
        System.out.println("Second Occurence : "+-1);
        }
        first = false;
        int end = occurrence(nums, low, high, target, first);
        System.out.println("First occurence : "+start);
        System.out.println("Second Occurence : "+end);
        
    }

    public static int occurrence(int[] nums, int low, int high, int target, boolean first) {
        int ind = -1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                ind = mid;
                if (first)
                    high = mid - 1;
                else
                    low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ind;
    }
}
