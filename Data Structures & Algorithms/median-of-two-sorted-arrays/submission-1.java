class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m =nums1.length;
        int n = nums2.length;
        int i=0,j=0;
        List<Integer> list =new ArrayList<>();
        while(i<m&&j<n){
            if(nums1[i]<=nums2[j]){
                list.add(nums1[i]);
                i++;
            }else{
                list.add(nums2[j]);
                j++;
            }
        }
        while(i<m)list.add(nums1[i++]);
        while(j<n)list.add(nums2[j++]);

        int size = list.size();

        if(size%2!=0){
            return list.get(size/2);
        }else{
            return (list.get(size/2-1)+list.get(size/2))/2.0;
        }
    }
    }
