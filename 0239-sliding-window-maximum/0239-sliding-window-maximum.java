class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n-k+1];

        //Brute-Force -- TLE
        // for(int i = 0; i <= n-k; i++){
        //     int max = Integer.MIN_VALUE;
        //     for(int j = i; j<i+k; j++){
        //         max = Math.max(max, nums[j]);
        //     }
        //     result[i] = max;
        // }
        // return result;

        //Optimal
        //store indices in decreasing order of their values
        Deque<Integer> dq = new ArrayDeque<>();

        for(int i =0; i<n; i++){

            //Remove indices that are outside the current window
            while(!dq.isEmpty() && dq.peekFirst() <= i-k){
                dq.pollFirst();
            }

            //Remove smaller or equal elements from the back
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }

            //Add the current element's index
            dq.offerLast(i);

            //Once the first window is complete, record its maximum
            if(i>=k-1){
                result[i-k+1] = nums[dq.peekFirst()];
            }
        }
        return result;
    }
}