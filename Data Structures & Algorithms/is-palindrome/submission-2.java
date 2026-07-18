class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        for(int i = 0, j = s.length() - 1; i < j && i < s.length(); i++,j--) {
            while(i < j && !isValid(s.charAt(i))) {
                i ++;
            }

            while(i < j && !isValid(s.charAt(j))) {
                j --;
            }
            if (i<j && s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }

        return true;
    }

    public boolean isValid(char c) {
        return Character.isLetterOrDigit(c);
    }
}
