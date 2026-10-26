class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Cell> pq = new PriorityQueue<>((Cell a, Cell b)->{
            return b.val - a.val;
        });
        int[] ans = new int[nums.length - k + 1];
        for(int i = 0; i < k; i ++) {
            pq.offer(new Cell(i, nums[i]));
        }
        ans[0] = pq.peek().val;
        for(int i = 1,j = k; j < nums.length; i++,j++) {
            pq.offer(new Cell(j, nums[j]));
            while(pq.peek().index < i) pq.poll();
            ans[i] = pq.peek().val;
        }

        return ans;
    }
}

class Cell{
    public int index;
    public int val;
    public Cell(int index, int val) {
        this.index = index;
        this.val = val;
    }
}
