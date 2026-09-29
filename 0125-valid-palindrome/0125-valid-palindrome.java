class Solution {
    public boolean isAlphaNumeric(char c){
        return (c>='a' && c<='z') || (c >='A' && c<='Z') || (c >= '0' && c <='9');
    }
    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0;
        int right = n-1;
       while(left < right){
            char c1 = s.charAt(left);
            char c2 = s.charAt(right);

            if(!isAlphaNumeric(c1)){
                left++;
                continue;
            }
            if(!isAlphaNumeric(c2)){
                right--;
                continue;
            }
            if(Character.toLowerCase(c1) != Character.toLowerCase(c2)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}