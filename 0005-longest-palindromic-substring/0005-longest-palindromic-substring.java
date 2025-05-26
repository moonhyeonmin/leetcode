class Solution {

    int max, tmp;

    public void extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        if (max < right - left - 1) {
            tmp = left + 1;
            max = right - left - 1;
        }
    }

    public String longestPalindrome(String s) {
        
        int len = s.length();

        if (len < 2) {
            return s;
        }

        for (int i = 0; i < len - 1; i++) {
            extendPalindrome(s, i, i + 1);
            extendPalindrome(s, i, i + 2);
        }

        return s.substring(tmp, tmp + max);
    }
}