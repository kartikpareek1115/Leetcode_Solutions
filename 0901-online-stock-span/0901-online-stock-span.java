class StockSpanner {
    ArrayList<Integer> prices = new ArrayList<>();
    public StockSpanner() {
        
    }
    
    public int next(int price) {
        prices.add(price);
        int count = 1;
        
        for(int i = prices.size() -2; i>=0; i-- ){
            if(prices.get(i) <= price ){
                count++;
            }
            else break;
        }
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */