
class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> entry : knowledge) {
            map.put(entry.get(0), entry.get(1));
        }

        StringBuilder result = new StringBuilder();
        StringBuilder key = new StringBuilder();
        boolean inside = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                inside = true;
            } else if (c == ')') {
                inside = false;
                result.append(map.getOrDefault(key.toString(), "?"));
                key.setLength(0);
            } else if (inside) {
                key.append(c);
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}