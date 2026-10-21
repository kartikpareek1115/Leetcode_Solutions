class Solution {
    public int largestRectangleArea(int[] heights) {

        //Brute force
        // int n = heights.length;
        // long maxArea = 0;
        // for(int i = 0; i< n; i++){
        //     int left = i;
        //     int right = i;
        //     while(left > 0 && heights[left-1]>= heights[i]){
        //         left--;
        //     }
        //     while(right +1 <n && 
        //           heights[right+1] >= heights[i]){
        //             right++;
        //           }

        //           long width = right - left + 1;

        //           long area = (long) heights[i] * width;
        //           maxArea = Math.max(maxArea, area);
        // }
        // return (int)maxArea;

        int n = heights.length;
        long maxArea =0; 
        Stack<Integer> st = new Stack<>();

        for(int i = 0;i<=n; i++){
          while (!st.isEmpty() &&
       (i == n || heights[st.peek()] > heights[i])) {
                int mid = st.pop();

                int left = st.isEmpty() ? -1 : st.peek();

                int right = i;

                long width = right - left -1;

                long area = (long) heights[mid] * width;

                maxArea = Math.max(maxArea, area);
            }
            if(i<n){
                st.push(i);
            }
          
        }
          return (int) maxArea;
    }
}