class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[] b)->{
            if(a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int ans = 0;

        for(int i = 1; i < intervals.length; i ++){
            if(intervals[i - 1][1] <= intervals[i][0]) continue;
            intervals[i][1] = Math.min(intervals[i - 1][1], intervals[i][1]);
            ans ++;
        }

        return ans;
    }
}
