class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), n, k, 1);

        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> elems, int n, int k, int start) {
        if (k == 0) {
            res.add(new ArrayList<>(elems));
            return;
        }

        for (int i = start; i <= n; i++) {
            elems.add(i);
            dfs(res, elems, n, k - 1, i + 1);
            elems.removeLast();
        }
    }
}