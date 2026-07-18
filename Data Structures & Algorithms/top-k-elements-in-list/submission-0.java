class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums) {
            if (freq.containsKey(num)) {
                freq.put(num, freq.get(num) + 1);
            } else{
                freq.put(num, 1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->{
            return freq.get(a) - freq.get(b);
        });

        for(int num:freq.keySet()){
            if (pq.size() < k) {
                pq.add(num);
            } else {
                if(freq.get(pq.peek()) < freq.get(num)) {
                    pq.poll();
                    pq.add(num);
                }
            }
        }
                int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }

        return result;
    }
}


