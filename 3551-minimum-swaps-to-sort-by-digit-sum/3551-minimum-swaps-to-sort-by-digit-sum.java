import java.util.Arrays;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        
        // Element wrapper storing the original value and its initial index
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Precompute digit sums to avoid redundant calculations during sorting
        int[] digitSum = new int[n];
        for (int i = 0; i < n; i++) {
            digitSum[i] = getDigitSum(nums[i]);
        }

        // Sort indices based on:
        // 1. Digit sum ascending
        // 2. Numerical value ascending (tie-breaker)
        Arrays.sort(indices, (a, b) -> {
            if (digitSum[a] != digitSum[b]) {
                return Integer.compare(digitSum[a], digitSum[b]);
            }
            return Integer.compare(nums[a], nums[b]);
        });

        // Find the number of disjoint cycles
        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            // If already visited or already in the correct sorted spot
            if (visited[i] || indices[i] == i) {
                continue;
            }

            // Traverse the cycle and count its length
            int cycleSize = 0;
            int curr = i;
            while (!visited[curr]) {
                visited[curr] = true;
                curr = indices[curr];
                cycleSize++;
            }

            if (cycleSize > 1) {
                swaps += (cycleSize - 1);
            }
        }

        return swaps;
    }

    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}