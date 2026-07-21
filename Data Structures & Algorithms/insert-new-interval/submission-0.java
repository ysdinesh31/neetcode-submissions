class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();

        for(int[] interval: intervals) {
            if(newInterval[0] > interval[1]){
                ans.add(interval);
            } else if (newInterval[1] < interval[0]){
                ans.add(newInterval);
                newInterval = interval;
            } else{
                newInterval = new int[]{Math.min(newInterval[0], interval[0]), Math.max(newInterval[1], interval[1])};
            }
        }
        ans.add(newInterval);
        int[][] array = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            array[i] = ans.get(i); // Automatically unboxed to int
        }

        return array;
    }
}
