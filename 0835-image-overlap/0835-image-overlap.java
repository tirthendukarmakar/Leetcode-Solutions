class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        java.util.List<int[]> ones1 = new java.util.ArrayList<>();
        java.util.List<int[]> ones2 = new java.util.ArrayList<>();

        // 1. Collect coordinates of all 1s
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (img1[r][c] == 1) {
                    ones1.add(new int[]{r, c});
                }
                if (img2[r][c] == 1) {
                    ones2.add(new int[]{r, c});
                }
            }
        }

        // If either image has no 1s, maximum overlap is 0
        if (ones1.isEmpty() || ones2.isEmpty()) {
            return 0;
        }

        // 2. Count frequency of translation vectors (dr, dc)
        // Since n <= 30, dr and dc are in [-29, 29].
        // Unique key encoding: dr * 100 + dc avoids object overhead.
        java.util.Map<Integer, Integer> count = new java.util.HashMap<>();
        int maxOverlap = 0;

        for (int[] p1 : ones1) {
            for (int[] p2 : ones2) {
                int dr = p2[0] - p1[0];
                int dc = p2[1] - p1[1];
                int key = dr * 100 + dc;

                int currentCount = count.getOrDefault(key, 0) + 1;
                count.put(key, currentCount);
                maxOverlap = Math.max(maxOverlap, currentCount);
            }
        }

        return maxOverlap;
    }
}