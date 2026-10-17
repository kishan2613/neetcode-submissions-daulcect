class Solution {
    public int[] countBits(int n) {
        int res[] = new int[n+1];

        for(int i=0;i<=n;i++){
            res[i]=    countone(i);
        }
    return res;
    }

    public int countone(int n){
        StringBuilder sb = new StringBuilder();
        while(n>0){
            int bit = n&1;
            sb.append(bit);
            n>>=1;
        }
        int count=0;
        for(int i=0;i<sb.length();i++){
            char ch = sb.charAt(i);

            if(ch=='1'){
                count++;
            }
        }
    return count;
    }
}
