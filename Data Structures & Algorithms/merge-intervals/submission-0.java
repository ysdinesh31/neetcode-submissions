class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> res = new ArrayList<>();

        res.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++) {
            int[] interval = res.get(res.size() - 1);
            if(intervals[i][0] > interval[1]) {
                res.add(intervals[i]);
            } else if(intervals[i][0] <= interval[1]) {
                interval[1] = Math.max(intervals[i][1], interval[1]);
            }
        }

        return res.toArray(new int[res.size()][2]);
    }
}
