class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;

        for(int num: nums) {
            set.add(num);
        }

        for(int num:nums) {
            if(!set.contains(num - 1)) {
                int count = 1;
                while(true) {
                    if (set.contains(num + 1)) {
                        count ++;
                        num ++;
                    } else {
                        break;
                    }
                }
                ans = Math.max(ans, count);
            }
        }

        return ans;
    }
}
