class Solution {
    public String largestEven(String s) {
        int lastTwoIdx = s.lastIndexOf('2');
    
        if (lastTwoIdx == -1) {
            return "";
        }
        
        
        return s.substring(0, lastTwoIdx + 1);
    }
}