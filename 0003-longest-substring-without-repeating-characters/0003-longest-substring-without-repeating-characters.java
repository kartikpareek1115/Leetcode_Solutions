class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastSeen = new int[256];
        Arrays.fill(lastSeen,-1);

        int left = 0;
        int maxLength = 0;

        for(int right = 0 ; right < s.length(); right++){
            char currentChar = s.charAt(right);

            if(lastSeen[currentChar] != -1){
                left = Math.max(left,lastSeen[currentChar]+1);
            }

            lastSeen[currentChar] = right;

            maxLength = Math.max(right - left + 1, maxLength);
        }
        return maxLength;
    }
}