class Solution {
    public int search(int[] nums, int target) {
        int m = 0;
        int mid = 0;
        int n = nums.length - 1;
        while (m <= n) {
            mid = m + (n - m)/2;

            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] > target) {
                n = mid - 1;
            } else {
                m = mid + 1;
            }
        }

        return -1;
    }
}
