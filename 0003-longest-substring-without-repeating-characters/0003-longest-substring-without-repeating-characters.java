class Solution {
    public int lengthOfLongestSubstring(String s) {
    HashMap<Character, Integer> map = new HashMap<>();

    int left = 0;
    int right = 0;
    int max = 0;

    for (char c : s.toCharArray()) {
        if (map.containsKey(c) && left <= map.get(c)) {
            left = map.get(c) + 1;
        } else {
            max = Math.max(right - left + 1, max);
        }


        map.put(c, right);
        right++;
        }

    return max;
    }
}