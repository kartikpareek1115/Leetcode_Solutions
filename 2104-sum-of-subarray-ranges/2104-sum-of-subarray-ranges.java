class Solution {
    public long subArrayRanges(int[] nums) {
        long sum = 0;
        long range = 0;
      
        for(int i=0; i<nums.length; i++){
              int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
            for(int j = i; j< nums.length; j++){
                 largest = Math.max(largest,nums[j]);
                 smallest = Math.min(smallest,nums[j]);
                  range = (long)largest-smallest;
                 sum += range;
            }
            
        }
        return sum;
    }
}