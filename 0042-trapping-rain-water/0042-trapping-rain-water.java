class Solution {
    public int trap(int[] height) {

        //Brute-Force
        int n = height.length;
        if(n<3) {
            return 0;
        }
        // int totalWater = 0;

        // for(int i = 0; i<n; i++){
        //     int leftmax = 0;
        //     int rightmax =0;

        //     for(int j = 0; j<=i ; j++){
        //         leftmax = Math.max(leftmax,height[j]);
        //     }

        //      for(int j = i; j<n ; j++){
        //         rightmax = Math.max(rightmax,height[j]);
        //     }

        //     int waterlevel = Math.min(leftmax, rightmax);

        //     totalWater += waterlevel - height[i];
        // }
        // return totalWater;


        //Optimal
        int left = 0;
        int right = n-1;
        int leftMax = 0;
        int rightMax = 0;
        int totalWater = 0;

        while(left<right){
            if(height[left] < height[right]){
                if(height[left] >= leftMax){
                    leftMax = height[left];
                }
                else{
                    totalWater += leftMax - height[left];
                }
                left++;
            }

            else{
                if(height[right] >= rightMax){
                    rightMax = height[right];
                }
                else{
                    totalWater += rightMax - height[right];
                }
                right--;
            }
        }
        return totalWater;
    }
}