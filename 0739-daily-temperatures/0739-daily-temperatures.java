class Solution {

    int last = 0;
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[temperatures.length];

        for (int i = 0;i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                last = stack.pop();
                res[last] = i - last;
            }

            stack.push(i);
        }

        return res;
    }
}