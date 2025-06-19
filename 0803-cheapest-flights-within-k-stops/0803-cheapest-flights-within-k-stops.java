import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.putIfAbsent(flight[0], new HashMap<>());
            graph.get(flight[0]).put(flight[1], flight[2]);
        }

        Queue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.get(1)));
        pq.add(Arrays.asList(src, 0, 0));

        Map<Integer, Integer> visit = new HashMap<>(); // 타임아웃 방지를 위해 한 번 방문한 경로를 저장

        while (!pq.isEmpty()) {
            List<Integer> curr = pq.poll();
            int u = curr.get(0);
            int price_u = curr.get(1);
            int visited = curr.get(2);


            if (u == dst) { // 만약 큐에서 추출한 값이 도착지 dst라면 정답으로 리턴
                return price_u;
            }

            // 도착지(U)까지의 진행 경로(visited) 저장, 따로 저장해두진 않지만 비용(price_u)이 가장 저렴한 경로임 (우선순위 큐)
            visit.put(u, visited);
            
            if (visited <= k) {
                visited += 1;
                if (graph.containsKey(u)) {
                    for (Map.Entry<Integer, Integer> v : graph.get(u).entrySet()) {
                        // 이미 계산한 경로는 큐에 삽입하지 않는 형태로 진행함
                        // 그러나 아직 계산한 경로가 아니거나, visite가 기존보다 작다면
                        // ds까지는 또 다른 최소 비용을 계산할 가능성이 있으므로 큐에 삽입해서 한 번 더 계산
                        if (!visit.containsKey(v.getKey()) || visited <= visit.get(v.getKey())) {
                            int alt = price_u + v.getValue();
                            pq.add(Arrays.asList(v.getKey(), alt, visited));
                        }
                    }
                }
            }
        }
        return -1;
    }
}