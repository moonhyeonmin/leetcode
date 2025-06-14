class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums.length == 0) {
            return res;
        }
        func(res, nums, new ArrayList<Integer>());
        return res;
    }

    public void func(List<List<Integer>> res, int[] nums, List<Integer> path) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int num : nums) {
            if (!path.contains(num)) {
                path.add(num);
            func(res, nums, path);
            path.remove(path.size() - 1);
            }
        }
    }
}