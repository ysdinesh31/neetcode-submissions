class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int[] edge : edges){
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.putIfAbsent(edge[1], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        System.out.println(map);

        int ans = 0;
        Set<Integer> visited = new HashSet<>();

        for(int i = 0; i < n; i ++){
            if(!visited.contains(i)){
                dfs(visited, map, i);
                ans += 1;
            }
        }

        return ans;
    }

    public void dfs(Set<Integer> visited, Map<Integer, List<Integer>> map, int node){
        visited.add(node);

        for(int n: map.getOrDefault(node, new ArrayList<>())){
            if (!visited.contains(n)){
                dfs(visited, map, n);
            }
        }
    }
}
