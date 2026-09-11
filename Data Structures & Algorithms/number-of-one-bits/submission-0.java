class Solution {
    public int hammingWeight(int n) {
        String binary = Integer.toBinaryString(n);
        int count=0;
        System.out.println(binary);
        for(int i=0;i<binary.length();i++){
            char ch = binary.charAt(i);
            if(ch=='1'){
                count++;
            }
        }
    return count;
    }
}
