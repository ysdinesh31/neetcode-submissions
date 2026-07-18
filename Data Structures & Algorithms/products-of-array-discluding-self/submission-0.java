class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftProduct = new int[nums.length];

        int product = 1;
        leftProduct[0] = 1;
        for(int i = 1; i < nums.length; i++){
            product *= nums[i - 1];
            leftProduct[i] = product;
        }

        product = 1;
        for(int i = nums.length - 2; i >= 0 ; i--) {
            product *= nums[i + 1];
            leftProduct[i] *= product;
        }

        return leftProduct;
    }
}  
