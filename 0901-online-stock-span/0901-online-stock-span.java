class StockSpanner {
    //ArrayList<Integer> prices = new ArrayList<>();
    public StockSpanner() {
        
    }
    Stack<int[]> st = new Stack<>();
    public int next(int price) {

        //Brute Force
    //     prices.add(price);
    //     int count = 1;
        
    //     for(int i = prices.size() -2; i>=0; i-- ){
    //         if(prices.get(i) <= price ){
    //             count++;
    //         }
    //         else break;
    //     }
    //     return count;
    // }
    int count = 1;
    while(!st.isEmpty() && st.peek()[0] <= price){
        count += st.pop()[1];
    }

    st.push(new int[]{price,count});

    return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */