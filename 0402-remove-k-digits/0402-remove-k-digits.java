class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> digits = new Stack<>();
        int remaining = k;

        for(char digit : num.toCharArray()){
            while(remaining > 0 && !digits.isEmpty()
                  && digits.peek() > digit){
                    digits.pop();
                    remaining--;
                  }
                  digits.push(digit);
        }

        while(remaining > 0 && !digits.isEmpty()){
            digits.pop();
            remaining--;
        }

        StringBuilder result = new StringBuilder();

        while(!digits.isEmpty()){
            result.append(digits.pop());
        }

        result.reverse();

        int start = 0;
        // Skip leading zeroes from the final number.
        while(start < result.length()
        && result.charAt(start) == '0'){
            start++;
        }
        // No remaining digit represents zero.
        if(start == result.length()){
            return "0";
        }

        return result.substring(start);
    }
}