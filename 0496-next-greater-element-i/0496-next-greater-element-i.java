class Solution {
    public int findIndex (int l, int[] nums2){
        for(int k = 0 ; k< nums2.length; k++){
            if(nums2[k] == l){
                return k;
            }
        }
        return -1;
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nge = new int[nums1.length];
        for(int i = 0; i <nums1.length; i++){
               nge[i] = -1;
            for(int j = findIndex(nums1[i],nums2) + 1; j<nums2.length; j++){
                if(nums2[j] > nums1[i]){
                    nge[i] = nums2[j];
                    break;
                }
                
            }
        }
        return nge;
    }
}