class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null  || matrix.length == 0) return 0;
    

    int rows = matrix.length;
    int cols = matrix[0].length;

    int[] heights = new int[cols];

    int maxArea =0;

    for(int i = 0; i < rows; i++){
        //Build the histogram for the current row
        for(int j = 0; j< cols; j++){
            if(matrix[i][j] == '1'){
                heights[j]++;
            }else{
                heights[j] = 0;
            }
        }
        maxArea = Math.max(maxArea,largestRectangleArea(heights));
    }
    return maxArea;
}

private int largestRectangleArea(int[] heights){
    int n = heights.length;
    int maxArea = 0;

    Stack<Integer> st = new Stack<>();

    for(int i = 0; i<=n ; i++){
        while(!st.isEmpty() && 
              (i ==n || heights[st.peek()] > heights[i])){
                int mid = st.pop();

                int left = st.isEmpty() ? -1 : st.peek();
                int right = i;

                int width = right - left - 1;
                int area = heights[mid] * width;

                maxArea = Math.max(maxArea, area);
              }

              if(i < n){
                st.push(i);
              }
    }
    return maxArea;
}
}