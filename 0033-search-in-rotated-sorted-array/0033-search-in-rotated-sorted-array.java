class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right])
                left = mid + 1;
            else
                right = mid;
        }
        int pivot = left;

        int idx = binarySearch(nums, 0, nums.length - 1, target, pivot);
        return idx;
    }

    public int binarySearch(int[] nums, int left, int right, int target, int pivot) {
        if (left > right)
            return -1;
        
        int mid = left + (right - left) / 2;
        int midPivot = (mid + pivot) % nums.length;
        if (nums[midPivot] > target) {
            return binarySearch(nums, left, mid - 1, target, pivot);
        } else if (nums[midPivot] < target) {
            return binarySearch(nums, mid + 1, right, target, pivot);
        } else {
            return midPivot;
        }
    }
}