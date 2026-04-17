import java.util.Random;

class Solution {
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int store = left;
        for (int i = left; i < right; i++) {
            if (nums[i] > pivot) {
                int tmp = nums[i];
                nums[i] = nums[store];
                nums[store] = tmp;
                store++;
            }
        }
        int tmp = nums[store];
        nums[store] = nums[right];
        nums[right] = tmp;
        return store;
    }

    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        k = k - 1;
        while (left <= right) {
            int pos = partition(nums, left, right);
            if (pos == k)
                return nums[pos];
            else if (pos < k)
                left = pos + 1;
            else
                right = pos - 1;
        }
        return -1;
    }
}