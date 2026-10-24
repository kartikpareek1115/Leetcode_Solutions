class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

       

        for(int asteroid : asteroids){
             boolean destroyed = false;

             while(!st.isEmpty() && st.peek() > 0 && asteroid < 0){
                if(st.peek() < Math.abs(asteroid)){
                    st.pop();
                } else if(st.peek() == Math.abs(asteroid)){
                    st.pop();
                    destroyed = true;
                    break;
                } else {
                    destroyed = true;
                    break;
                }
             }

             // Add the current asteroid if it survived all the collisions.
             if(!destroyed){
                st.push(asteroid);
             }
        }
        int[] result = new int[st.size()];

        for(int i = 0; i< st.size(); i++){
            result[i] = st.get(i);
        }
        return result;
    }
}