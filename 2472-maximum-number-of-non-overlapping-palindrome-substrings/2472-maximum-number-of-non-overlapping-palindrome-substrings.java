class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int count = 0;
        int lastEnd = 0;

        for (int i = k - 1; i < n; i++) {
            // Check substring of length k ending at i
            int startK = i - k + 1;
            if (startK >= lastEnd && isPalindrome(s, startK, i)) {
                count++;
                lastEnd = i + 1;
                continue;
            }

            // Check substring of length k + 1 ending at i
            int startKPlus1 = i - k;
            if (startKPlus1 >= lastEnd && isPalindrome(s, startKPlus1, i)) {
                count++;
                lastEnd = i + 1;
            }
        }

        return count;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}