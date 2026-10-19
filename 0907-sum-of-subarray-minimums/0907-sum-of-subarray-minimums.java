class Solution {
    public int sumSubarrayMins(int[] arr) {

        // Brute Force -- TLE 
        int modulo = 1_000_000_007;
        long sum = 0;
        int n = arr.length;
        // for(int i = 0; i< arr.length; i++){
        //     int min = arr[i];
        //     for(int j = i ; j< arr.length; j++){
        //         min = Math.min(min,arr[j]);
        //         sum = (sum+min)%modulo;
        //     }
            
        // }
        // return sum;

        Stack<Integer> st = new Stack<>();

        for(int i=0; i<=n; i++){
            while(!st.isEmpty() && 
                  (i == n|| arr[st.peek()] >= arr[i])){

                    int mid = st.pop();
                    int left = st.isEmpty() ? -1 : st.peek();
                    int right = i;

                    long leftCount = mid - left;
                    long rightCount = right - mid;

                    sum = (sum+(long) arr[mid] * leftCount * rightCount) % modulo;
                  }

                  if(i<n){
                    st.push(i);
                  }
               
        }
           return (int) sum;
    }
}