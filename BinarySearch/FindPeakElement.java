class Main{
    public static void main(String[] args){
        
        int[] nums = {6,5,4,3,2,3,2};

        int res = findPeak(nums);
        /* Peak element : nums[i-1] < nums[i] > nums[i+1]  */
        System.out.println("Peak element in the array is at index: "+res);
    }
    public static int findPeak(int[] nums){
        int n = nums.length;
        if (n == 1) return 0;
        if (n == 2) return nums[0] > nums[1] ? 0 : 1;

        int l=1;
        int r  = nums.length-2;

        while(l<=r){

            int mid = (l+r)/2;

            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                return mid;
            }else if(nums[mid] > nums[mid-1] && nums[mid] < nums[mid+1]){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        if (nums[0] > nums[1]) return 0;
        if (nums[n - 1] > nums[n - 2]) return n - 1;
        
        return -1;
    }
}