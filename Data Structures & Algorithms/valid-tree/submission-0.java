class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1){
            return false;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i ++){
            map.put(i, new ArrayList<>());
        }

        for(int[] edge : edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        dfs(0, map, visited);

        if(visited.size() != n){
            return false;
        }

        return true;
    }

    public void dfs(int node, Map<Integer, List<Integer>> map, Set<Integer> visited){
        visited.add(node);

        for(int neighbor: map.get(node)){
            if(!visited.contains(neighbor)){
                dfs(neighbor, map, visited);
            }
        }
    }
}
