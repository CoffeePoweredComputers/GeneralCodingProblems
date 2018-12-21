class TwoMissingElements{

    public static String getString(int[] arr){

        StringBuilder string = new StringBuilder("[");
        
        //get all of the numbers
        for(int num: arr){
            string.append(" ");
            string.append(Integer.toString(num));
            string.append(" ");
        }
        string.append("]");

        return string.toString();
    }

    public static int[] findMissingTwo(int[] arr){
        int ans[] = new int[2];

        return ans;
    }   

    public static void main(String[] args){

        //setup some arrays to use
        int[] arr1 = {1,2,4,5,6,7,8};
        int[] arr2 = {1,3,4,5,6,7,9};
        int[] arr3 = {1,2,3,4,7,8,9};

        //finds the missing elment for each of the arrays
        int arr1_missing = findMissingTwo(arr1);
        int arr2_missing = findMissingTwo(arr2);
        int arr3_missing = findMissingTwo(arr3);

        //output the results
        System.out.printf("The array %s is missing %d\n",getString(arr1),arr1_missing);
        System.out.printf("The array %s is missing %d\n",getString(arr2),arr2_missing);
        System.out.printf("The array %s is missing %d\n",getString(arr3),arr3_missing);

    }
}