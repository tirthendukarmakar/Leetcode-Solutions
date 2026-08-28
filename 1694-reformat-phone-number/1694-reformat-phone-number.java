class Solution {
    public String reformatNumber(String number) {
        StringBuilder digits = new StringBuilder();
        for (char c : number.toCharArray()) {
            if (Character.isDigit(c)) {
                digits.append(c);
            }
        }

        StringBuilder result = new StringBuilder();
        int i = 0;
        int n = digits.length();

        // Step 2: Group into blocks of 3 as long as more than 4 digits remain
        while (n - i > 4) {
            result.append(digits.substring(i, i + 3)).append("-");
            i += 3;
        }

        // Step 3: Handle the remaining 4 or fewer digits
        int remaining = n - i;
        if (remaining == 4) {
            // Split 4 digits into two blocks of length 2
            result.append(digits.substring(i, i + 2))
                  .append("-")
                  .append(digits.substring(i + 2, i + 4));
        } else {
            // 2 or 3 digits remaining: append as a single block
            result.append(digits.substring(i));
        }

        return result.toString();
    }
}