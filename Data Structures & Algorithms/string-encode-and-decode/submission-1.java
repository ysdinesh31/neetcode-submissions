class Solution {

    public String encode(List<String> strs) {
        StringBuilder ans = new StringBuilder();
        for (String str: strs) {
            ans.append(str.length()).append('#').append(str);
        }
        return ans.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < str.length(); i++) {
            int j = i;
            while(str.charAt(j) != '#'){
                j ++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            String substr = str.substring(j + 1, j + 1 + length);
            ans.add(substr);
            i = j + length;
        }

        return ans;
    }
}
