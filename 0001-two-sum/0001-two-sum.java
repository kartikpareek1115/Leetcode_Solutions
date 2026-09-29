class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        // for(int i  = 0; i< nums.length; i++){
           
        //     for(int j = i+1; j<nums.length; j++){
               
        //         if(nums[i] + nums[j]== target){
        //             return new int[]{i,j};
        //         }
        //     }
        // }
        // return null;

        //2-pointer -- applicable only indices are not asked
        // Arrays.sort(nums);
        // int  n = nums.length;
        // int left = 0;
        // int right = n-1;

        // while(left < right){
        //     int sum = nums[left] + nums[right]; 
        //     if(sum == target){
        //         return new int[]{left,right};
        //     }
        //    else if(sum > target){
        //     right--;
        //    }
        //    else if(sum < target){
        //     left++;
        //    }
            
        // }
        // return null;

        //Better approach -- Hashmap
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            int required = target - nums[i];
            if(map.containsKey(required)){
                return new int[]{map.get(required),i};
            }
            map.put(nums[i] , i);
        }
        return new int[]{};
    }
}