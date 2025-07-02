class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> group = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();

        for(int num1 : nums1) 
            group.add(num1);

        for(int num2 : nums2) {
            if (group.contains(num2)) {
                res.add(num2);
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}