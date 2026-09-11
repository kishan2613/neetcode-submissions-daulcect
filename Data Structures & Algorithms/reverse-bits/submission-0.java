class Solution {
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            int bit = n & 1;          // get last bit
            result = (result << 1) | bit;
            n >>>= 1;                 // unsigned right shift
        }

        return result;
     
    }
}
