class Solution {
    public boolean isAnagram(String s, String t) {
        return sort(s).equals(sort(t));
    }

    public String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}