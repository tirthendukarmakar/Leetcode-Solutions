class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) return false;

        int sum = 1; // 1 is a divisor for all positive integers > 1
        
        // Find divisors in pairs up to the square root of num
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i * i != num) { // Avoid adding the square root twice for perfect squares
                    sum += num / i;
                }
            }
        }
        
       
        return sum == num;
    }
}