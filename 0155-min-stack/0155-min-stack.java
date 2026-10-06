class MinStack {

    LinkedList<int[]> stack = new LinkedList<>();
    public MinStack() {
        
    }
    
    public void push(int value) {
        if(stack.isEmpty() ){
            stack.add(new int[]{value,value});
        }
        else{
            int min = Math.min(value,stack.getLast()[1]);
            stack.add(new int[]{value,min});
        }
    }
    
    public void pop() {
        stack.removeLast();
    }
    
    public int top() {
        return stack.getLast()[0];
    }
    
    public int getMin() {
        return stack.getLast()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */