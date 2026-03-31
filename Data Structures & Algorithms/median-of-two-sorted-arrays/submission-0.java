class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list= new ArrayList<>();

        int i=0,j=0;
        int n = nums1.length;
        int m = nums2.length;

        while(i<n&&j<m){
            if(nums1[i]<=nums2[j]){
                list.add(nums1[i]);
                i++;
            }else{
                list.add(nums2[j]);
                j++;
            }
        }

         while (i < n) list.add(nums1[i++]);
        while (j < m) list.add(nums2[j++]);

        int y =list.size();
        
        if(y%2!=0){
            return list.get(y/2);
        }else{
            return (list.get(y/2 -1)+list.get(y/2))/2.0;
        }
    }
    }
