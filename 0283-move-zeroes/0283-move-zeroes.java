class Solution {
    public void moveZeroes(int[] nums) {
        // int[] result = new int[nums.length];

        // int j = 0;
        // for(int i = 0; i<nums.length; i++){
        //     if(nums[i] != 0){
        //     result[j] = nums[i];
        //     j++;
        //     }
            
        // }
        // for(int i = 0; i<nums.length; i++){
        //     nums[i] = result[i];
        // }

        //two pointer
           int j = 0;
        for(int i = 0; i<nums.length; i++){
         
            if(nums[i] !=0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                j++;
            }
        }
    }
}