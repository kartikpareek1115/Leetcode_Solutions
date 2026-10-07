class MinStack {

    // LinkedList<int[]> stack = new LinkedList<>();
    // public MinStack() {
        
    // }
    
    // public void push(int value) {
    //     if(stack.isEmpty() ){
    //         stack.add(new int[]{value,value});
    //     }
    //     else{
    //         int min = Math.min(value,stack.getLast()[1]);
    //         stack.add(new int[]{value,min});
    //     }
    // }
    
    // public void pop() {
    //     stack.removeLast();
    // }
    
    // public int top() {
    //     return stack.getLast()[0];
    // }
    
    // public int getMin() {
    //     return stack.getLast()[1];
    // }

  
    Stack<Long> stack = new Stack<>();
    long min = Long.MAX_VALUE;

    public MinStack() {
    }

    public void push(int value) {
        if (stack.isEmpty()) {
            stack.push((long) value);
            min = value;
        }
        else if (value >= min) {
            stack.push((long) value);
        }
        else {
            stack.push(2L * value - min);
            min = value;
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }

        long val = stack.pop();

        if (val < min) {
            min = 2 * min - val;
        }
    }

    public int top() {
        long top = stack.peek();

        if (top < min) {
            return (int) min;
        }

        return (int) top;
    }

    public int getMin() {
        return (int) min;
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