import java.math.BigInteger;
import java.util.*;

class Solution {
    public String largestNumber(int[] nums) {
        // insertion sort 로직은 그대로…
        int i = 1;
        while (i < nums.length) {
            int j = i;
            while (j > 0 && toSwap(nums[j - 1], nums[j])) {
                int tmp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = tmp;
                j--;
            }
            i++;
        }

        if (nums[0] == 0)
            return "0";
        else
            return Arrays.toString(nums).replaceAll("\\[|\\]|,|\\s", "");
    }

    // toSwap: n1+n2 조합이 n2+n1 보다 작으면 true
    private boolean toSwap(int n1, int n2) {
        BigInteger v1 = new BigInteger(String.valueOf(n1) + n2);
        BigInteger v2 = new BigInteger(String.valueOf(n2) + n1);
        return v1.compareTo(v2) < 0;
    }
}