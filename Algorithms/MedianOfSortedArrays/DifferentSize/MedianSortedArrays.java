import java.util.*; 
import java.lang.*; 
import java.io.*; 

class MedianSortedArrays {
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


//
//THE FOLLOWING MAIN WAS TAKEN FROM L33TCODE.COM AND IS NOT MY WORK
//
class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static String doubleToString(double input) {
        return Double.toString(input);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums1 = stringToIntegerArray(line);
            line = in.readLine();
            int[] nums2 = stringToIntegerArray(line);
            
            double ret = new MedianSortedArrays().findMedianSortedArrays(nums1, nums2);
            
            String out = doubleToString(ret);
            
            System.out.print(out);
        }
    }
}