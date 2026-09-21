class Solution {
public boolean isPalindrome(int x) {
    if (x < 0) {
        return false;
    }

    int original = x;
    long s = 0; // Using long prevents integer overflow

    while (x > 0) {
        int r = x % 10;
        s = s * 10 + r;
        x = x / 10;
    }

    return original == s;
}
}