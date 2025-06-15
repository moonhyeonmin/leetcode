class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> elems, int[] candidates, int target, int index) {
        if (elems.stream().mapToInt(Integer::intValue).sum() == target) {
            res.add(new ArrayList<>(elems));
            return;
        } else if (elems.stream().mapToInt(Integer::intValue).sum() > target) return;

        for (int i = index; i < candidates.length; i++) {
            elems.add(candidates[i]);
            dfs(res, elems, candidates, target, i);
            elems.removeLast();
        }
    }
}