class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        if (n == 1) {
            return List.of(0);
        }

        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0 ; i < n;i ++) {
            if (graph.get(i).size() == 1)
                leaves.add(i);
        }

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newleaves = new ArrayList<>();
            for (int leaf : leaves) {
                int neighbor = graph.get(leaf).get(0);
                graph.get(neighbor).remove((Object) leaf);
                if (graph.get(neighbor).size() == 1) newleaves.add(neighbor);
            }

            leaves = newleaves;
        }

        return leaves;
    }
}