class OneMissingElement{

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

    public static int findMissing(int[] arr){

        int xorTotal = 0;
        int xorArr = 0;

        //xor everything in the range
        for(int i = 1; i <= arr.length + 1; i++) xorTotal ^= i;

        //xor everything in the array
        for(int num: arr) xorArr ^= num;

        //return the xor of the two total which should be the missing number
        return xorArr ^ xorTotal;
    }

    public static void main(String[] args){

        //setup some arrays to use
        int[] arr1 = {1,2,4,5,6,7,8,9};
        int[] arr2 = {1,3,4,5,6,7,8,9};
        int[] arr3 = {1,2,3,4,6,7,8,9};

        //finds the missing elment for each of the arrays
        int arr1_missing = findMissing(arr1);
        int arr2_missing = findMissing(arr2);
        int arr3_missing = findMissing(arr3);

        //output the results
        System.out.printf("The array %s is missing %d\n",getString(arr1),arr1_missing);
        System.out.printf("The array %s is missing %d\n",getString(arr2),arr2_missing);
        System.out.printf("The array %s is missing %d\n",getString(arr3),arr3_missing);

    }
}