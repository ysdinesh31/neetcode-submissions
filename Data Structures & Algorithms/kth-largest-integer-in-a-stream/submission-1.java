class KthLargest {
    public PriorityQueue<Integer> pq;
    public int range;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>((Integer a, Integer b) -> {
            return a - b;
        });
        range = k;
        for(int num : nums) {
            this.add(num);
        }
    }
    
    public int add(int val) {
        if(pq.size() < range) {
            pq.offer(val);
        } else {
             if (pq.peek() < val) {
                if(pq.size() == range) pq.poll();
                pq.offer(val);
            }
        }
        return pq.peek();

    }
}
