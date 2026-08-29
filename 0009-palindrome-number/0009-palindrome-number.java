class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
        return false;
        int n=x,s=0,r;
        while(n>0)
        {
            r=n%10;
            s=s*10+r;
            n=n/10;
        }return s==x;

    }
}