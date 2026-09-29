class Solution {
    public int thirdMax(int[] nums) {
        // long v1 = Long.MIN_VALUE;
        // long v2 = Long.MIN_VALUE;
        // long v3 = Long.MIN_VALUE;
        // for(int i = 0; i<nums.length; i++){
        //     if(nums[i] == v1 ||nums[i] == v2 ||nums[i] == v3 ){
        //         continue;
        //     }
        //     if(nums[i] > v1){
        //         v3 = v2;
        //         v2 = v1;
        //         v1 = nums[i]; 
        //     }
        //     else if(nums[i] > v2){
        //         v3 = v2;
        //         v2 = nums[i];
        //     }
        //     else if(nums[i] > v3){
        //         v3 = nums[i];
        //     }
        // }
        // if(v3 == Long.MIN_VALUE) return (int)v1;
        // else return (int)v3;


        //min-heap  --> priorityQueue
       PriorityQueue<Integer> pq = new PriorityQueue<>();
HashSet<Integer> set = new HashSet<>();

for (int num : nums) {

    if (set.contains(num)) {
        continue;
    }

    set.add(num);

    if (pq.size() < 3) {
        pq.add(num);
    }
    else if (num > pq.peek()) {
        pq.poll();
        pq.add(num);
    }
}

if (pq.size() < 3) {
    return pq.stream().max(Integer::compareTo).get();
}

return pq.peek();
    }

    
}