class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        int maxLeft = height[left];
        int maxRight = height[right];

        while(left < right) {
            if(maxLeft < maxRight) {
                left += 1;
                if (maxLeft > height[left]){
                    ans += maxLeft - height[left];
                }
                maxLeft = Math.max(height[left], maxLeft);
            } else {
                right -= 1;
                if(maxRight > height[right]) {
                    ans += maxRight - height[right];
                }
                maxRight = Math.max(height[right], maxRight);
            }
        }

        return ans;
    }
}
