class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        // dp[r] stores the number of valid subarrays ending at the current index with product % k == r
        long[] dp = new long[k];

        for (int num : nums) {
            long[] nextDp = new long[k];
            int val = num % k;

            // 1. Subarray consisting only of the current element
            nextDp[val]++;

            // 2. Extend subarrays ending at the previous index
            for (int r = 0; r < k; r++) {
                if (dp[r] > 0) {
                    int nextRem = (int) ((1L * r * val) % k);
                    nextDp[nextRem] += dp[r];
                }
            }

            // Accumulate counts into the global result
            for (int r = 0; r < k; r++) {
                result[r] += nextDp[r];
            }

            dp = nextDp;
        }

        return result;
    }
}