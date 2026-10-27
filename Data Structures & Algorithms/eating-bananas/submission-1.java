class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        for(int pile: piles) {
            right = Math.max(pile, right);
        }

        int ans = right;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(possible(piles, h, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
    public boolean possible(int[] piles, int h, int speed) {
        int hCalc = 0;
        for(int pile:piles) {
            hCalc += Math.ceil((pile * 1.0)/speed);
        }
        return hCalc <= h;
    }
}
