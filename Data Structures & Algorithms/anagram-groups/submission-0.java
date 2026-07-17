class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s:strs) {
            char[] sArray = s.toCharArray();
            Arrays.sort(sArray);
            String res = new String(sArray);

            if(map.containsKey(res)){
                map.get(res).add(s);
            } else {
                List<String> grp = new ArrayList<>();
                grp.add(s);
                map.put(res, grp);
            }
        }

        return new ArrayList<>(map.values());
    }
}
