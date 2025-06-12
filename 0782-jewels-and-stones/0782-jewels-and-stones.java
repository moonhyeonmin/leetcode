class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> map = new HashMap<>();

        for (char stone : stones.toCharArray()) {
            if (map.containsKey(stone)) {
                map.put(stone, map.get(stone) + 1);
            } else {
                map.put(stone, 1);
            }
        }

        int res = 0;
        for (char jewel : jewels.toCharArray()) {
            if (map.containsKey(jewel)) {
                res += map.get(jewel);
            }
        }

        return res;
    }
}