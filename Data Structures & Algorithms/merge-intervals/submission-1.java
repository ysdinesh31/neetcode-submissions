class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return intervals;
        Arrays.sort(intervals, (int[] a, int[] b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            int[] lastInterval = ans.get(ans.size() - 1);
            if(lastInterval[1] < intervals[i][0]){
                ans.add(intervals[i]);
            } else{
                lastInterval[1] = Math.max(lastInterval[1], intervals[i][1]);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
