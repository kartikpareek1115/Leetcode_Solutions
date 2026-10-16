class Solution {
    public int[] nextGreaterElements(int[] nums) {

        //Brute-Force --> failing with -1 test case hence using the boolean
        // int[] nge = new int[nums.length];
        // for(int i = 0; i< nums.length; i++){
        //     nge[i] = -1;
        //      boolean found = false;
        //     for(int j = i+1; j<nge.length; j++){
        //         if(nums[j] > nums[i]){
        //             nge[i] = nums[j];
        //             found = true;
        //             break;
        //         }
        //     }
        //       if(!found){
        //             for(int k = 0; k < i; k++){
        //                 if(nums[k] > nums[i]){
        //                     nge[i] = nums[k];
        //                     break;
        //                 }
                        
        //             }
        //         }
        // }
        // return nge;

        //Better
        int[] nge = new int[nums.length];
        int n = nums.length;
        for(int i = 0; i<n; i++){
            nge[i] = -1;
            for(int j = i+1; j< i+n; j++){
                int index = j%n;
                if(nums[index] > nums[i]){
                    nge[i] = nums[index];
                    break;
                }
            }
        }
        return nge;

        
    }
}