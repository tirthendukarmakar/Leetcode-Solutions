class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) return result;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();

        queue.offer(s);
        visited.add(s);

        boolean foundValidAtLevel = false;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String cur = queue.poll();

                if (isValid(cur)) {
                    result.add(cur);
                    foundValidAtLevel = true;
                }

                // If a valid string was already found in this level, don't generate the next level
                if (foundValidAtLevel) continue;

                for (int j = 0; j < cur.length(); j++) {
                    char c = cur.charAt(j);
                    if (c != '(' && c != ')') continue;

                    // Remove char at j
                    String next = cur.substring(0, j) + cur.substring(j + 1);
                    if (visited.add(next)) {
                        queue.offer(next);
                    }
                }
            }

            if (foundValidAtLevel) break;
        }

        return result;
    }

    private boolean isValid(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') count++;
            else if (c == ')') {
                count--;
                if (count < 0) return false;
            }
        }
        return count == 0;
    }
}