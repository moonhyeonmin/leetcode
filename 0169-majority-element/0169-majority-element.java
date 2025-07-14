class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Map<Integer, Integer> sort = new LinkedHashMap<>();
        map.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .forEachOrdered(x -> sort.put(x.getKey(), x.getValue()));


            Map.Entry<Integer, Integer> entry = sort.entrySet().iterator().next();

            if (entry.getValue() > nums.length / 2)
                return entry.getKey();

            return -1;
    }
}