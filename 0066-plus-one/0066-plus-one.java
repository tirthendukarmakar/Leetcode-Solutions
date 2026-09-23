class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        
        // Handles cases where all digits were 9 (e.g., [9, 9] -> [1, 0, 0])
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        return newNumber;
    }
}