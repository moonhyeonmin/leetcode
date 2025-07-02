class Solution {
    public void sortColors(int[] nums) {
        int red = 0, white = 0, blue = nums.length;

        while (white < blue) {
            if (nums[white] < 1) {
                int tmp = nums[white];
                nums[white] = nums[red];
                nums[red] = tmp;
                red++;
                white++;
            } else if (nums[white] > 1) {
                blue--;
                int tmp = nums[blue];
                nums[blue] = nums[white];
                nums[white] = tmp;
            } else {
                white++;
            }
        }
    }
}