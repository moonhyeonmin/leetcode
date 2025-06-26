class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));
        List<int []> merge = new ArrayList<>();

        for (int[] i : intervals) {
            if (!merge.isEmpty() && i[0] <= merge.get(merge.size() - 1)[1]) {
                merge.get(merge.size() - 1)[1] = Math.max(merge.get(merge.size() - 1)[1], i[1]);
            }
            else {
                merge.add(i);
            }
        }

        return merge.toArray(new int[merge.size()][]);
    }
}