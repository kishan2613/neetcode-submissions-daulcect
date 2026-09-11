class Solution {
    public int[] countBits(int n) {
        int res[] = new int[n+1];

        for(int i=0;i<=n;i++){
            res[i] = countone(i);
        }

    return res;
    }

    public int countone(int n){
        int count=0;
        StringBuilder str = new StringBuilder();
        while(n>0){
            int bit = n&1;
            str.append(bit);
            n>>=1;
        }

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='1')count++;
        }

    return count;
    }
}
