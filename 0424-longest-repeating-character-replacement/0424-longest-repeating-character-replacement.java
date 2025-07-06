class Solution {
    public int characterReplacement(String s, int k) {

        int left = 0;
        int right = 0;
        Map<Character, Integer> counts = new HashMap<>();
        for (right = 1; right <= s.length(); right++) {
            counts.put(s.charAt(right - 1), counts.getOrDefault(s.charAt(right - 1), 0) + 1);
            int max = Collections.max(counts.values());

            if (right - left - max > k) {
                counts.put(s.charAt(left), counts.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            }
        }

        return right - left - 1;
        
    }
} 