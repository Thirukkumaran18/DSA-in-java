class Main{
    public static void main(String[] args){
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m= 3 ;  // number of valid elements in nums1
        int[] nums2 = {2, 5, 6};
        int n =3 ;  // number of valid elements in nums2
        merge(nums1, m, nums2, n);

        System.out.println("Merged array be like : ");
        for(int num : nums1){
            System.out.print(num+" ");
        }
        System.out.println();
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int r = m+n-1;
        int mI = m-1;
        int nI = n-1;

        while(nI >=0){

            if(mI>=0 && nums1[mI] > nums2[nI]){
                nums1[r] = nums1[mI];
                mI--;
            }else{
                nums1[r] = nums2[nI];
                nI--;
            }
            r--;
        }
    }
}

/*

Time complexity : O(m+n) 
Need not consider about r, because thats being handled in m or n iteration itself

Space complexity : O(1)
No extra space used

*/