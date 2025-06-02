class Solution {
    public boolean isValid(String s) {
        
        Deque<Character> deq = new ArrayDeque<>();
        Map<Character, Character> table = new HashMap<>() {{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};

        for (int i = 0; i < s.length(); i++) {
            if (!table.containsKey(s.charAt(i))) {
                deq.push(s.charAt(i));
            } else if (deq.isEmpty() || table.get(s.charAt(i)) != deq.pop())
                return false;
        }

        return deq.size() == 0;
    }
}