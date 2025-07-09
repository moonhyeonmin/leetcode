class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] arr = new int[gas.length];
        int res = 0;

        for (int i = 0 ; i < gas.length; i++) {
            arr[i] = gas[i] - cost[i];
        }

        if (Arrays.stream(arr).sum() < 0)
            return -1;

        int start = 0, fuel = 0;
        for (int i = 0; i < arr.length; i++) {
            if (fuel + arr[i] < 0) {
                start = i + 1;
                fuel = 0;
            } else {
                fuel += arr[i];
            }
        }

        return start;
    }
}