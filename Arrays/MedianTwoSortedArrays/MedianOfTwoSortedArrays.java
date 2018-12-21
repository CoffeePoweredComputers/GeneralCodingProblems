class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        //things to keep track of stuff...
        int n = nums1.length;
        int m = nums2.length;
        Integer[] merged = new Integer[n + m];
        
        //A little merging function
        int index_n = 0;
        int index_m = 0;
        int index_merged = 0;
        while(index_n < n && index_m < m){
            
            //check the state of things
            if(nums1[index_n] > nums2[index_m]){
                merged[index_merged++] = nums2[index_m++];
            } else{
                merged[index_merged++] = nums1[index_n++];
            }
        }
        
        //add the rest of nums1 if any
        while(index_n < n){
            merged[index_merged++] = nums1[index_n++];
        }

        //add the rest of num2 if any
        while(index_m < m){
            merged[index_merged++] = nums2[index_m++];
        }
        
        //figure out the median
        if( (n + m) % 2 == 0){
            int index = (int)Math.ceil((n + m) / 2);
            return (double)(merged[index] + merged[index-1])/2;
        }else{
            return (double)merged[(n + m)/2];
        }
        
    }
}