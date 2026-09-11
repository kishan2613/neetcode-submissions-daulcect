class Solution {
    public int hammingWeight(int n) {
        StringBuilder binary = new StringBuilder();
        int count=0;        

        while (n > 0) {
            int bit = n & 1;
            binary.append(bit);
            n >>= 1;
        }

        for(int i=0;i<binary.length();i++){
            char ch = binary.charAt(i);
            if(ch=='1'){
                count++;
            }
        }
    return count;
    }
}
