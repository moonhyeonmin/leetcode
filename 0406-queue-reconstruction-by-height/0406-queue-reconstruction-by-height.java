class Solution {
    public int[][] reconstructQueue(int[][] people) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0]- a[0] : a[1] - b[1]);
        List<int[]> res = new ArrayList<>();

        for (int[] person : people) {
            pq.add(person);
        }

        while (!pq.isEmpty()) {
            int[] person = pq.poll();
            res.add(person[1], person);
        }

        return res.toArray(new int[people.length][2]);

    }
}