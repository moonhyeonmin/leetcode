class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new ArrayList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();

        for (List<String> ticket : tickets) {
            map.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            map.get(ticket.get(0)).add(ticket.get(1));
        }

        dfs(res, map, "JFK");
        return res;

    }

    public void dfs(List<String> res, Map<String, PriorityQueue<String>> map, String start) {
        while (map.containsKey(start) && !map.get(start).isEmpty()) {
            dfs(res, map, map.get(start).poll());
        }

        res.add(0, start);
    }
}