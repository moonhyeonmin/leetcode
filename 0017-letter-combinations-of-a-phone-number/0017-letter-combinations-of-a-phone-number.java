class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits.length() == 0)
            return res;

        Map<Character, List<String>> dic = new HashMap<>();
        dic.put('0', List.of());
        dic.put('1', List.of());
        dic.put('2', List.of("a", "b", "c"));
        dic.put('3', List.of("d", "e", "f"));
        dic.put('4', List.of("g", "h", "i"));
        dic.put('5', List.of("j", "k", "l"));
        dic.put('6', List.of("m", "n", "o"));
        dic.put('7', List.of("p", "q", "r", "s"));
        dic.put('8', List.of("t", "u", "v"));
        dic.put('9', List.of("w", "x", "y", "z"));

        dfs(res, dic, digits, 0, new StringBuilder());
        return res;
    }

    public void dfs(List<String> res, Map<Character, List<String>> dic, String digits, int index, StringBuilder path) {
        if (path.length() == digits.length()) {
            res.add(path.toString());
            return;
        }

        List<String> letters = dic.get(digits.charAt(index));
        for (String c : letters) {
            path.append(c);
            dfs(res, dic, digits, index + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}