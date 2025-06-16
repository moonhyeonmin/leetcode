class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), nums, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> path, int[] nums, int k) {

        res.add(new ArrayList<>(path));

        for (int i = k; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(res, path, nums, i + 1);
            path.removeLast();
        }
    }
}