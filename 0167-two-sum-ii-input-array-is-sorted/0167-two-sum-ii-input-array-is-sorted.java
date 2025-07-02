class Solution {
    public int[] twoSum(int[] numbers, int target) {
        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            int tar = binarySearch(numbers, i + 1, numbers.length - 1, target - numbers[i]);
            if (tar >= 0) {
                return new int[] {i + 1, tar + 1};
            }
        }

        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right)
            return -1;
        
        int mid = left + (right - left) / 2;
        if (nums[mid] > target) {
            return binarySearch(nums, left, mid - 1, target);
        } else if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, right, target);
        } else {
            return mid;
        }
    }
}