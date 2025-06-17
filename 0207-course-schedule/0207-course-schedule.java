class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pre : prerequisites) {
            map.putIfAbsent(pre[0], new ArrayList<>());
            map.get(pre[0]).add(pre[1]);
        }

        List<Integer> take = new ArrayList<>();
        List<Integer> taken = new ArrayList<>();
        for (Integer finish : map.keySet()) {
            if (!dfs(map, finish, take, taken)) return false;
        }

        return true;
    }

    public boolean dfs(Map<Integer, List<Integer>> map, Integer finish, List<Integer> take, List<Integer> taken) {
        if (take.contains(finish)) return false;
        if (taken.contains(finish)) return true;
        
        if (map.containsKey(finish)) {
            take.add(finish);
            for (Integer i : map.get(finish)) {
                if (!dfs(map, i, take, taken)) return false;
            }

            take.remove(finish);
            taken.add(finish);
        }

        return true;
    }
}