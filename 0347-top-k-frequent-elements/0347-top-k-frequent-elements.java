class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        Map<Integer, List<Integer>> bucket = new HashMap<>();
        for (int elem : map.keySet()) {
            int cnt = map.get(elem);
            List<Integer> elems = bucket.getOrDefault(cnt, new ArrayList<>());
            elems.add(elem);
            bucket.put(cnt, elems);
        }

        int[] res = new int[k];
        int idx = 0;
        for (int cnt = nums.length; cnt >= 0 && idx < k; cnt--) {
            if (bucket.get(cnt) != null) {
                for (int elem : bucket.get(cnt)) {
                    res[idx] = elem;
                    idx++;
                }
            }
        }

        return res;
    }
}