class Solution {
    public void reverseString(char[] s) {
    //     char[] r = new char[s.length];
    //     int j = 0;
    //     for(int i = s.length-1; i>=0; i--){
    //         r[j] = s[i];
    //         j++;
    //     }
        
    //    for(int i = 0; i<s.length; i++){
    //     s[i] = r[i];
    //    }

    //2-pointer
    int n = s.length;
    int left = 0;
    int right = n-1;
    while(left < right){
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;

        left++;
        right--;
    }

    


    }
}