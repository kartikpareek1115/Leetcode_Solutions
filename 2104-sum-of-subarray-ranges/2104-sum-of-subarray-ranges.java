class Solution {
    public long subArrayRanges(int[] nums) {
        //Brute-Force
        // long sum = 0;
        // long range = 0;
      
        // for(int i=0; i<nums.length; i++){
        //       int largest = Integer.MIN_VALUE;
        // int smallest = Integer.MAX_VALUE;
        //     for(int j = i; j< nums.length; j++){
        //          largest = Math.max(largest,nums[j]);
        //          smallest = Math.min(smallest,nums[j]);
        //           range = (long)largest-smallest;
        //          sum += range;
        //     }
            
        // }
        // return sum;

         // Sum of all subarray maximums - sum of all subarray minimums
         return sumOfMax(nums) - sumOfMin(nums);
    }

    private long sumOfMin(int[] nums){
        int n = nums.length;
        long sum = 0;
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<=n; i++){
            while(!st.isEmpty() && 
                   (i==n || nums[st.peek()] >= nums[i])) {
                    int mid = st.pop();

                    int left = st.isEmpty() ? -1 : st.peek();
                    int right = i;

                    long leftCount = mid - left;
                    long rightCount = right - mid;

                    sum += (long) nums[mid] * leftCount * rightCount;
                   }

                   if(i < n){
                    st.push(i);
                   }
        }
        return sum;
    }

    private long sumOfMax(int[] nums){
        int n = nums.length;
        long sum =0;
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i<=n ; i++){
            while(!st.isEmpty() &&
                   (i ==n || nums[st.peek()] <= nums[i])){
                    int mid = st.pop();
                        int left = st.isEmpty() ? -1 : st.peek();
                int right = i;

                long leftCount = mid - left;
                long rightCount = right - mid;

                sum += (long) nums[mid] * leftCount * rightCount;
                   }
                   if (i < n) {
                st.push(i);
            }
        }
          return sum;
    }
}