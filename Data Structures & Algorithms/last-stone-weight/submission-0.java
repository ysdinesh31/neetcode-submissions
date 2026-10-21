class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((Integer a, Integer b)->{
            return b - a;
        });

        for(int stone : stones) {
            pq.add(stone);
        }

        while(pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            if(a == b) continue;
            else{
                pq.offer(Math.abs(a - b));
            }
        }

        if(pq.size() == 0) return 0;
        return pq.peek();

    }
}
