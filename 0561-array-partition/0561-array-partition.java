class Solution {
    public int arrayPairSum(int[] nums) {
        int sum = 0;
        List<Integer> pair = new ArrayList<>();
        Arrays.sort(nums);

        for (int n : nums) {
            pair.add(n);
            if (pair.size() == 2) {
                sum += Collections.min(pair);
                pair.clear();
            }
        }

        return sum;
    }
}