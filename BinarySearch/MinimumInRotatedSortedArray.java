class Main{
    public static void main(String[] args){

        int nums[] = {5,1,2,3,4};
        
        int l = 0 ;
        int r = nums.length-1;

        int ans = Integer.MAX_VALUE;
        while(l<=r){
            int mid = (l+r)/2;

            ans = Math.min(nums[mid], ans);

           if(nums[l] <= nums[mid] && nums[mid] >= nums[r]){
            l=mid+1;
           }else{
            r=mid-1;
           }
        }
        System.out.println("Minimum element is : "+ans);
    }
}