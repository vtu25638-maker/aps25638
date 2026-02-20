import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        Map<Integer, Integer> mp = new HashMap<>();
        int[] ans = new int[nums.length - (k - 1)];

       
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int j = 0;

        for (int i = 0; i < nums.length; i++) {

            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
            pq.add(nums[i]);

            if (i - j + 1 == k) {

              
                while (!pq.isEmpty() && mp.getOrDefault(pq.peek(), 0) == 0) {
                    pq.poll();
                }

                int ele = pq.peek();
                ans[j] = ele;

                
                mp.put(nums[j], mp.get(nums[j]) - 1);

                j++;
            }
        }
        return ans;
    }
}